package com.saurav.MusicStreamingService.repository;

import com.saurav.MusicStreamingService.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,Integer> {
    Admin findFirstByAdminEmail(String email);
}
