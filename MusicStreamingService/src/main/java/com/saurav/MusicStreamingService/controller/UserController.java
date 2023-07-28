package com.saurav.MusicStreamingService.controller;
import com.saurav.MusicStreamingService.dto.SignInInput;
import com.saurav.MusicStreamingService.enums.UserType;
import com.saurav.MusicStreamingService.model.PlayList;
import com.saurav.MusicStreamingService.model.User;
import com.saurav.MusicStreamingService.service.AuthenticationTokenService;
import com.saurav.MusicStreamingService.service.UserService;
import com.saurav.MusicStreamingService.util.ValidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationTokenService authenticationTokenService;
    @PostMapping("/signUp")
    public String SignUpUser(@RequestBody User user) throws NoSuchAlgorithmException {
        if(user.getUserType() == UserType.GENERAL && !ValidateUser.isValidUser(user.getUserEmail())) {
            return userService.SignUpUser(user);
        }
        return "Invalid User";
    }
    @PostMapping("/signIn")
    public String signInUser(@RequestBody SignInInput sign) throws NoSuchAlgorithmException {
        if(!ValidateUser.isValidUser(sign.getEmail())) {
            return userService.signInUser(sign);
        }
        return "Please Enter Valid Email And Password";
    }
    @DeleteMapping("signOut")
    public String signOutUser(@RequestParam String userEmail,@RequestParam String authenticationToken){
        if(authenticationTokenService.authenticate(userEmail,authenticationToken)){
            return userService.signOutUser(userEmail);
        }
        return "Unauthorized activity deducted";
    }
    @PostMapping("/playlist")
    public String addPlaylist(@RequestParam String email, @RequestParam String authenticationToken, @RequestBody PlayList playList){
        if(authenticationTokenService.authenticate(email,authenticationToken)){
            return userService.addPlaylist(playList,email);
        }
        return "Unauthorized activity deducted";
    }
    @GetMapping("/playlist")
    public List<PlayList>getAllPlayList(@RequestParam String email, @RequestParam String authenticationToken){
        if(authenticationTokenService.authenticate(email,authenticationToken)){
            return userService.getAllPlaylist(email);
        }
        return null;
    }
    @PutMapping("/playlist")
    public String updatePlaylistByUser(@RequestParam String email, @RequestParam String authenticationToken,@RequestBody PlayList playList){
        if(authenticationTokenService.authenticate(email,authenticationToken)){
            return userService.updatePlaylistByUser(playList,email);
        }
        return "Unauthorized activity deducted";
    }
    @DeleteMapping("/playlist")
    public String deletePlaylistByID(@RequestParam String email, @RequestParam String authenticationToken,@RequestParam Integer playlistID){
        if(authenticationTokenService.authenticate(email,authenticationToken)){
            return userService.deletePlaylistByID(playlistID,email);
        }
        return "Unauthorized activity deducted";
    }

}
