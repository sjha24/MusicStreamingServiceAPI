package com.saurav.MusicStreamingService.service;
import com.saurav.MusicStreamingService.dto.SignInInput;
import com.saurav.MusicStreamingService.model.AuthenticationToken;
import com.saurav.MusicStreamingService.model.PlayList;
import com.saurav.MusicStreamingService.model.User;
import com.saurav.MusicStreamingService.repository.AuthenticationTokenRepo;
import com.saurav.MusicStreamingService.repository.UserRepo;
import com.saurav.MusicStreamingService.util.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    AuthenticationTokenRepo authenticationTokenRepo;
    @Autowired
    PlayListService playListService;
    public String SignUpUser(User user) throws NoSuchAlgorithmException {

        User existUser = userRepo.findFirstByUserEmail(user.getUserEmail());

        if(existUser != null){
            return "You are Already SignUp so please SignIn Your account";

        }
        String password = user.getUserPassword();
        String encryptPassword = PasswordEncrypter.encryptPassword(password);
        user.setUserPassword(encryptPassword);
        userRepo.save(user);
        return user.getUserName()+" SignUp successfull";
    }

    public String signInUser(SignInInput sign) throws NoSuchAlgorithmException {
        boolean signInStatus = true;
        String message = null;
        String signInEmail = sign.getEmail();

        User existUser = userRepo.findFirstByUserEmail(sign.getEmail());

        if(existUser == null){
            signInStatus = false;
            message = "Invalid Email or Password";
            return message;
        }
        String encryptPassword = PasswordEncrypter.encryptPassword(sign.getPassword());

        if(existUser.getUserPassword().equals(encryptPassword)){

            if(authenticationTokenRepo.findFirstByUser(existUser)==null) {

                AuthenticationToken authToken = new AuthenticationToken(existUser);
                authenticationTokenRepo.save(authToken);
                message = existUser.getUserName()+" SignIn Successfull your Id is "+existUser.getUserID()+" and your AuthenticationToken is "+authToken.getTokenValue()+" Please Remember Your Token Form Next Request";
                return message;
            }
            return "You are already LogIn";
        }
        message = "Invalid Email or Password";
        return message;
    }
    public String signOutUser(String userEmail) {

        User user = userRepo.findFirstByUserEmail(userEmail);
        if(user != null){

            AuthenticationToken authenticationToken = authenticationTokenRepo.findFirstByUser(user);
            authenticationTokenRepo.delete(authenticationToken);
            return user.getUserName()+" Your account SignOut Successfull";
        }
        return "You are Already SignOut";
    }

    public String addPlaylist(PlayList playList, String email) {

        User existUser = userRepo.findFirstByUserEmail(email);

        if(existUser.getUserID().equals(playList.getUser().getUserID())) {
            return playListService.addPlaylist(playList, existUser);
        }
        return "Please Enter Valid Detail";
    }

    public List<PlayList> getAllPlaylist(String email) {
        User existUser = userRepo.findFirstByUserEmail(email);
        return playListService.getAllPlaylist(existUser);
    }

    public String updatePlaylistByUser(PlayList playList, String email) {

        User existUser = userRepo.findFirstByUserEmail(email);
        return playListService.updatePlaylistByUser(playList,existUser);
    }

    public String deletePlaylistByID(Integer playlistID, String email) {

        User existUser = userRepo.findFirstByUserEmail(email);

        return playListService.deletePlaylistByID(playlistID,existUser);
    }

}
