package com.saurav.MusicStreamingService.model;

import com.saurav.MusicStreamingService.enums.Genre;
import com.saurav.MusicStreamingService.enums.UserType;
import io.swagger.v3.oas.annotations.links.Link;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "song_table")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer songID;
    @NotEmpty
    private String songName;
    @NotBlank
    private String songArtist;
    @NotEmpty(message = "song link must not be Empty")
    private String songLink;
    private String songDuration;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

}
