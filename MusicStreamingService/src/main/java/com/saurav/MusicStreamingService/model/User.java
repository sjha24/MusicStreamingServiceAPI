package com.saurav.MusicStreamingService.model;

import com.saurav.MusicStreamingService.enums.Gender;
import com.saurav.MusicStreamingService.enums.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;
    @NotEmpty(message = "User Name should not be Empty")
    private String userName;
    @Enumerated(value = EnumType.STRING)
    private UserType userType;
    @NotBlank(message = "User Email Should not be Blank")
    private String userEmail;
    @NotBlank(message = "User Password Should not be Blank")
    private String userPassword;
    @Size(min = 10,max = 12)
    @Pattern(regexp = "^[0-9]+$")
    private String userContactNum;
    @Enumerated(value = EnumType.STRING)
    private Gender userGender;
}
