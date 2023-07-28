package com.saurav.MusicStreamingService.service;

import com.saurav.MusicStreamingService.dto.SignInInput;
import com.saurav.MusicStreamingService.model.*;
import com.saurav.MusicStreamingService.repository.AdminRepo;
import com.saurav.MusicStreamingService.repository.AuthenticationTokenRepo;
import com.saurav.MusicStreamingService.util.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminRepo adminRepo;
    @Autowired
    SongService songService;
    public  boolean authenticateAdmin(String adminEmail,String adminPassword) throws NoSuchAlgorithmException {
        Admin existAdmin = adminRepo.findFirstByAdminEmail(adminEmail);
        String password = PasswordEncrypter.encryptPassword(adminPassword);
        if(existAdmin != null && existAdmin.getAdminPassword().equals(password)){
            return true;
        }
        return false;
    }
    public String registerAdmin(Admin admin) throws NoSuchAlgorithmException {
        Admin existAdmin = adminRepo.findFirstByAdminEmail(admin.getAdminEmail());
        if(existAdmin != null){
            return "You Are Already Register";
        }
        String password = PasswordEncrypter.encryptPassword(admin.getAdminPassword());
        admin.setAdminPassword(password);
        adminRepo.save(admin);
        return admin.getAdminName()+ " is Registered Successfull";
    }

    public String addSong(Song song) {
        return songService.addSong(song);
    }

    public List<Song> getAllSong() {
        return songService.getAllSong();
    }

    public String updateSong(Song song) {
        return songService.updateSong(song);
    }

    public String deleteSongByID(Integer songID) {
        return songService.deleteSongByID(songID);
    }
}
