package com.saurav.MusicStreamingService.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "playlist_table")
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playListId;
    @NotEmpty
    private String playListName;
    @ManyToOne
    @JoinColumn(name = "fk_user_ID")
    private User user;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Playlist_Song_table",joinColumns = @JoinColumn(name = "playlist_ID"),inverseJoinColumns = @JoinColumn(name = "song_ID"))
    private List<Song>songList;
}
