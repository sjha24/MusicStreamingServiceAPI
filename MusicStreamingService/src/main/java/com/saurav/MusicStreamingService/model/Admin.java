package com.saurav.MusicStreamingService.model;

import com.saurav.MusicStreamingService.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.saurav.MusicStreamingService.util.ValidateUser.EMAIL_REGEX;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin_table")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminID;
    private String adminName;
    private Gender adminGender;
    @Pattern(regexp = EMAIL_REGEX)
    private String adminEmail;
    private String adminPassword;

    @OneToMany
    @JoinColumn(name = "admin_Id")
    private List<Song>songs;
}
