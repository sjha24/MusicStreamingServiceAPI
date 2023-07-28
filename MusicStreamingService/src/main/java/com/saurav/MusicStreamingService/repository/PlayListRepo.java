package com.saurav.MusicStreamingService.repository;

import com.saurav.MusicStreamingService.dto.PlaylistOutput;
import com.saurav.MusicStreamingService.model.Admin;
import com.saurav.MusicStreamingService.model.PlayList;
import com.saurav.MusicStreamingService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayListRepo extends JpaRepository<PlayList,Integer> {
    List<PlayList> findByUser(User existUser);
    PlayList findFirstByUser(User existUser);
    PlayList findByPlayListName(String playListName);
}
