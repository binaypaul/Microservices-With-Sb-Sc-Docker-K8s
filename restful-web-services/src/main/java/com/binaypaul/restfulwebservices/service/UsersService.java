package com.binaypaul.restfulwebservices.service;

import com.binaypaul.restfulwebservices.mapstruct.dto.User;
import com.binaypaul.restfulwebservices.service.exception.UserNotFoundException;

import java.util.List;

public interface UsersService {
    List<User> getAllUsers();
    User getUserByUserId(long userId) throws UserNotFoundException;
    User createUser(User user);
}
