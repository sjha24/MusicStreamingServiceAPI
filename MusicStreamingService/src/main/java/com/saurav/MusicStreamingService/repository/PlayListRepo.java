package com.saurav.MusicStreamingService.repository;

import com.saurav.MusicStreamingService.model.PlayList;
import com.saurav.MusicStreamingService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayListRepo extends JpaRepository<PlayList,Integer> {
    List<PlayList> findByUser(User existUser);
    PlayList findFirstByUser(User existUser);
}
