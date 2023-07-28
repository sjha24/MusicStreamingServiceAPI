package com.saurav.MusicStreamingService.dto;
import com.saurav.MusicStreamingService.model.Song;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistOutput {
    @NotBlank(message = "PlayList name can't be blank")
    private String playListName;

    @OneToMany
    private List<Song> songs;
}
