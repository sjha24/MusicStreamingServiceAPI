package com.saurav.MusicStreamingService.service;

import com.saurav.MusicStreamingService.model.Admin;
import com.saurav.MusicStreamingService.model.PlayList;
import com.saurav.MusicStreamingService.model.Song;
import com.saurav.MusicStreamingService.repository.AdminRepo;
import com.saurav.MusicStreamingService.repository.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    SongRepo songRepo;

    @Autowired
    AdminRepo adminRepo;
    public String addSong(Song song) {
        songRepo.save(song);
        return song.getSongName()+" Is Added";
    }

    public List<Song> getAllSong() {
        return songRepo.findAll();
    }

    public String updateSong(Song song) {
        Song existSong = songRepo.findById(song.getSongID()).orElse(null);
        if(existSong != null){
            String oldSongName = existSong.getSongName();
            existSong.setSongID(song.getSongID());
            existSong.setSongName(song.getSongName());
            existSong.setSongArtist(song.getSongArtist());
            existSong.setSongLink(song.getSongLink());
            existSong.setSongDuration(song.getSongDuration());
            existSong.setGenre(song.getGenre());
            songRepo.save(existSong);
            return oldSongName + " Is Updated to "+song.getSongName();
        }
        return song.getSongName()+" is Not Exist";
    }

    public String deleteSongByID(Integer songID) {
        Song song = songRepo.findById(songID).orElse(null);
        if(song != null) {
            songRepo.deleteById(song.getSongID());
            return "This Song is Deleted Successfully";
        }
        return "Id "+songID+" with this Song is not Present !!!";
    }

}