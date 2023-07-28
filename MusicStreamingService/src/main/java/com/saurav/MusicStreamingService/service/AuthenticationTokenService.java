package com.saurav.MusicStreamingService.service;

import com.saurav.MusicStreamingService.model.AuthenticationToken;
import com.saurav.MusicStreamingService.repository.AuthenticationTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationTokenService {
    @Autowired
    AuthenticationTokenRepo authenticationTokenRepo;
    public boolean authenticate(String email,String authTokenValue){
        AuthenticationToken authenticationToken = authenticationTokenRepo.findFirstByTokenValue(authTokenValue);
        if(authenticationToken!= null) {
            String tokenConnectedEmail = authenticationToken.getUser().getUserEmail();
            return tokenConnectedEmail.equals(email);
        }
        return false;
    }

}
