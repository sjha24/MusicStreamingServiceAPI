package com.saurav.MusicStreamingService.repository;
import com.saurav.MusicStreamingService.model.Admin;
import com.saurav.MusicStreamingService.model.AuthenticationToken;
import com.saurav.MusicStreamingService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationTokenRepo extends JpaRepository<AuthenticationToken,Integer> {
    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);;
    AuthenticationToken findFirstByAdmin(Admin existAdmin);
}
