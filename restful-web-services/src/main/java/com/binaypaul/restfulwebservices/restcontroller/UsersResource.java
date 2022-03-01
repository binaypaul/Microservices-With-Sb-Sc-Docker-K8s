package com.binaypaul.restfulwebservices.restcontroller;

import com.binaypaul.restfulwebservices.mapstruct.dto.*;
import com.binaypaul.restfulwebservices.restcontroller.exception.UserResourceNotFoundException;
import com.binaypaul.restfulwebservices.service.UsersService;
import com.binaypaul.restfulwebservices.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersResource {

    @Autowired
    @Qualifier("usersServiceImpl")
    private UsersService usersService;

    @GetMapping("")
    public List<User> getAllUsers() {
        List<User> userList = usersService.getAllUsers();
        return userList;
    }

    @GetMapping("/{userId}")
    public User getUserByUserId(@PathVariable long userId) {
        User user = null;
        try {
            user = usersService.getUserByUserId(userId);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            throw new UserResourceNotFoundException();
        }
        return user;
    }

    @PostMapping("")
    public ResponseEntity createUser(@RequestBody User user) {
        user = usersService.createUser(user);
        URI newUserUri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/{userId}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(newUserUri).body(user);
    }

    @PostMapping("/dummy")
    public ResponseEntity createDummyUser() {
        UserProfilePost userProfilePost = (UserProfilePost) UserProfile.builder()
                .name("Binay Paul")
                .birthDate(new Date())
                .email("binay.paul@gmail.com")
                .bio("I am a dev..!")
                .userAddressSet(
                        Collections.singleton(UserAddress.builder()
                                .addressLine1("Roopena Agrahara")
                                .addressLine2("Bommanahalli")
                                .city("Bengaluru")
                                .state("Karnataka")
                                .pincode(560068)
                                .build()
                        )
                )
                .build();
        userProfilePost.toBuilder().password("abcde").build();

        User user = User.builder()
                .userProfile(userProfilePost)
                .orderSet(Collections.singleton(Order.builder()
                                        .date(new Date())
                                .build()
                        )
                )
                .build();
        user = usersService.createUser(user);
        URI newUserUri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/{userId}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(newUserUri).body(user);
    }
}
