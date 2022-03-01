package com.binaypaul.restfulwebservices.service.impl;

import com.binaypaul.restfulwebservices.mapstruct.dto.User;
import com.binaypaul.restfulwebservices.entity.UserEntity;
import com.binaypaul.restfulwebservices.mapstruct.mapper.MapStructMapper;
import com.binaypaul.restfulwebservices.repository.UserRepository;
import com.binaypaul.restfulwebservices.service.UsersService;
import com.binaypaul.restfulwebservices.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MapStructMapper mapper;

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<User> users = userEntities.stream().map(mapper :: userEntityToUser).collect(Collectors.toList());
        return users;
    }

    @Override
    public User getUserByUserId(long userId) throws UserNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if(userEntity.isEmpty()) throw new UserNotFoundException();
        return mapper.userEntityToUser(userEntity.get());
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = mapper.userToUserEntity(user);
        userEntity = userRepository.save(userEntity);
        return mapper.userEntityToUser(userEntity);
    }
}
