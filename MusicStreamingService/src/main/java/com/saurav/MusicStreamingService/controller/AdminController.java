package com.saurav.MusicStreamingService.controller;

import com.saurav.MusicStreamingService.dto.SignInInput;
import com.saurav.MusicStreamingService.enums.UserType;
import com.saurav.MusicStreamingService.model.Admin;
import com.saurav.MusicStreamingService.model.PlayList;
import com.saurav.MusicStreamingService.model.Song;
import com.saurav.MusicStreamingService.model.User;
import com.saurav.MusicStreamingService.service.AdminService;
import com.saurav.MusicStreamingService.service.AuthenticationTokenService;
import com.saurav.MusicStreamingService.util.ValidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @PostMapping("/RegisterAdmin")
    public String SignUpUser(@RequestBody Admin admin) throws NoSuchAlgorithmException {
        if(ValidateUser.isValidUser(admin.getAdminEmail())) {
            return adminService.registerAdmin(admin);
        }
        return "Invalid admin Email or Password";
    }
    @PostMapping("/song")
    public String addSong(@RequestParam String adminEmail,@RequestParam String adminPassword , @RequestBody Song song) throws NoSuchAlgorithmException {
        if(ValidateUser.isValidUser(adminEmail)){
            if(adminService.authenticateAdmin(adminEmail,adminPassword)) {
                return adminService.addSong(song);
            }
            return "Invalid Email or Password";
        }
        return "Unauthorized activity deducted";
    }
    @GetMapping("/song")
    public List<Song> getAllSong(@RequestParam String adminEmail, @RequestParam String adminPassword) throws NoSuchAlgorithmException {
        if(ValidateUser.isValidUser(adminEmail)){
            if(adminService.authenticateAdmin(adminEmail,adminPassword)) {
                return adminService.getAllSong();
            }
        }
        return null;
    }
    @PutMapping("/song")
    public String updateSong(@RequestParam String adminEmail, @RequestParam String adminPassword,@RequestBody Song song) throws NoSuchAlgorithmException {
        if(ValidateUser.isValidUser(adminEmail)){
            if(adminService.authenticateAdmin(adminEmail,adminPassword)){
                return adminService.updateSong(song);
            }
        }
        return "Unauthorized activity deducted";
    }
    @DeleteMapping("/song")
    public String deleteSongByID(@RequestParam String adminEmail, @RequestParam String adminPassword,@RequestParam Integer songID) throws NoSuchAlgorithmException {
        if(ValidateUser.isValidUser(adminEmail)){
            if(adminService.authenticateAdmin(adminEmail,adminPassword)) {
                return adminService.deleteSongByID(songID);
            }
        }
        return "Unauthorized activity deducted";
    }
}
