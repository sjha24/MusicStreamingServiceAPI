package com.saurav.MusicStreamingService.repository;

import com.saurav.MusicStreamingService.model.Admin;
import com.saurav.MusicStreamingService.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepo extends JpaRepository<Song,Integer> {

}
