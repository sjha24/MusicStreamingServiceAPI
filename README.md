# MusicStreamingServiceAPI
[![Java](https://img.shields.io/badge/Java>=8.0-blue.svg)](https://docs.spring.io/spring-boot/docs/0.5.0.M6/api/org/springframework/boot/SpringApplication.html)
[![maven](https://img.shields.io/badge/maven->=3.0.5-green.svg)](https://www.npmjs.com/package/npm/v/5.5.0)
[![springBoot](https://img.shields.io/badge/SpringBoot->=3.0.6-blue.svg)](https://nodejs.org/en/blog/release/v9.3.0)
>This project is a Music Streaming Service API that allows users and Admin to manage songs and playlists. It provides endpoints for CRUD operations on songs and playlists, with additional features for admin.

[Homepage]();

## Framework used
 * Spring Boot
## Languaged Uesd
 * Java
## Dependencies
 * Spring Web
 * Spring boot Devtool
 * Spring Data JPA
 * lombok
 * MySQL Driver
 * Validation
 * swagger

## Data Model
>The data model is defined in the Hotel Room Model class, which has the following attributes
```
* Admin
adminID (Integer) : Unique identifier for Admin ID and Generation Type AUTO.
adminName (String) : Admin Name
adminEmail (String) : Admin Email.
adminPassword (String) : Admin Password.

* User

userId (Integer) : Unique identifier for User ID and Generation Type AUTO.
userName (String) : User Full Name.
UserType (Enum-string) : User Type -> Admin and General.
userEmail (String) : User Email.
userPassword (String) : User Password.
userGernder (Enum-String) : User Gender Male,Female and Other.
userContactNum(String): User Contact Number

* Playlist

playlistID (Integer) : Unique identifier for playlist ID and Generation Type AUTO.
playlistName (String) : Playlist Name.
User user (ManyToOne) : Mapping Use-> Many Playlist exist can one User
Song song (ManyToMany(cascade = CascadeType.PERSIST)) : Many song can exist in Many Playlist.

* Song

songID (Integer) : Unique identifier for Song ID and Generation Type AUTO.
songName (String) : Song Name
songArtist (String) : Song Artist
songLink (String) : Song Link
songDuration (String) : Song Duration
songGenre (Enum-String) :  Pop_music,
    Bollywood,Rock,Hip_Hop,Folk_Music,
Devotional_Bhajans,Indian_Pop,Filmi_Sangeet,
    Fusion,Bhangra,Indian_Rock,Classical_Rock

* AuthenticationToken

tokenId (Long) :  Unique identifier for Patient Id Generation Type AUTO.
tokenValue (String) : Token value genrated By UUID in Random form.
tokenCreationDateTime (LocalDateTime) : Token Creation Date Time.
```
## Validation
```
To validate the input we get from client, we've used validation annotations that are used to enforce specific constraints on the values of the variables. These constraints ensure that the data input by the user is of the correct format and meets certain criteria.
* @Valid - In Spring Framework, the @Valid annotation is used in conjunction with @PostMapping and @PutMapping annotations, which are used to handle POST and PUT requests, respectively. When used with @PostMapping or @PutMapping, the @Valid annotation is typically applied to a method parameter annotated with @RequestBody.
* @NotEmpty: This annotation is used to validate that the annotated field is not null or empty.
* @NotNull: This annotation is used to validate that the annotated field is not null.
* @Max : This annotation is used to validate that the annotated field is not greater than the mentioned value in field.
* @Min : This annotation is used to validate that the annotated field is not smaller than the mentioned value in field.
```
## Data Flow
```
1. User send as a request to the application throgh the endpoints
2. the api recived request and sends it to the appropriate controll method
3. the controller method makes a call to the method in service class.
4. he controller method returns a response to the API
5. The API sends the response back to the user
```
## Api End Points
The following endpoints are available in the API:
* Admin Controller
```
POST/admin/RegisterAdmin : Register Admin

GET/admin/song : Get All Song from Database

PUT/admin/song : Update Song

POST/admin/song : Add Song In Database

DELETE/admin/song : Delete Song from Database
```
* User Controller
```
POST/user/signUp : Register User 

POST/user/signIn

DELETE/user/signOut

GET/user/playlist

PUT/user/playlist

POST/user/playlist

DELETE/user/playlist
```
## Data Structure Used
* SQL database
```
We have used Persistent database to implement CRUD Operations.
```

## Project Summary
```
The project is a basic web application built using Java and the Spring framework. It allows users to sign up, sign in, and manage their profile information. Admin can also create and songs. The application uses authentication tokens to secure user data and ensure that only authenticated users can access certain features. The API endpoints include user signup, signin, and update details and authentication token creation.
```
## Author

Saurav Kumar

* twiter : [@saurav](https://twitter.com/Sauravjha24)
* Github : [@sjha](https://github.com/sjha24)

## Contributing

Contributions , issues and features requestes are welcome !

Feel free to check issues page

## Show your support

Give a rating if this project help you

## License

Copyright : 2023 [Saurav Kumar]()
This project is [GeekSter](https://www.geekster.in/) license
