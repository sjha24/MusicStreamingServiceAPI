package com.saurav.MusicStreamingService.repository;

import com.saurav.MusicStreamingService.model.Admin;
import com.saurav.MusicStreamingService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findFirstByUserEmail(String userEmail);
}
