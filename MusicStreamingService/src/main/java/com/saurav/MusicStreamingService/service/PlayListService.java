package com.saurav.MusicStreamingService.service;

import com.saurav.MusicStreamingService.dto.PlaylistOutput;
import com.saurav.MusicStreamingService.model.AuthenticationToken;
import com.saurav.MusicStreamingService.model.PlayList;
import com.saurav.MusicStreamingService.model.Song;
import com.saurav.MusicStreamingService.model.User;
import com.saurav.MusicStreamingService.repository.PlayListRepo;
import com.saurav.MusicStreamingService.repository.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayListService {
    @Autowired
    PlayListRepo playListRepo;
    @Autowired
    SongRepo songRepo;
    public String addPlaylist(PlayList playList, User existUser) {

        PlayList existPlaylist = playListRepo.findFirstByUser(existUser);

        if(existPlaylist != null && existPlaylist.getPlayListName().equals(playList.getPlayListName())) {

            return existUser.getUserName() + " This Playlist is already Exist In Your account so Try to add Another playlist";
        }
        playListRepo.save(playList);

        return existUser.getUserName() + " playlist Added In Your Account";
    }

    public List<PlayList> getAllPlaylist(User existUser) {
        return playListRepo.findByUser(existUser);
    }

    public String updatePlaylistByUser(PlayList newPlayList, User existUser) {

        PlayList playList = playListRepo.findById(newPlayList.getPlayListId()).orElse(null);

        assert playList != null;

        if(playList.getUser().getUserID().equals(existUser.getUserID())){

            playList.setPlayListId(newPlayList.getPlayListId());
            playList.setPlayListName(newPlayList.getPlayListName());

            playList.setSongList(newPlayList.getSongList());

            playListRepo.save(playList);

            return "update to "+newPlayList.getPlayListName()+" successfull";
        }
        return "This Playlist Id "+ newPlayList.getPlayListId()+" is not Exist";

    }

    public String deletePlaylistByID(Integer playlistID, User existUser) {

        PlayList playList = playListRepo.findById(playlistID).orElse(null);

        assert playList != null;

        if(playList.getUser().getUserID().equals(existUser.getUserID())){
            playListRepo.deleteById(playlistID);

            return "Deleted Successfully of this playlist id "+playlistID;
        }
        return "This playlist Id "+playlistID+" is not exist in your account";
    }

}