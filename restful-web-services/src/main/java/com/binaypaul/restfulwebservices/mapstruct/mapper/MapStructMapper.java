package com.binaypaul.restfulwebservices.mapstruct.mapper;

import com.binaypaul.restfulwebservices.entity.OrderEntity;
import com.binaypaul.restfulwebservices.entity.UserAddressEntity;
import com.binaypaul.restfulwebservices.entity.UserEntity;
import com.binaypaul.restfulwebservices.entity.UserProfileEntity;
import com.binaypaul.restfulwebservices.mapstruct.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    Order orderEntityToOrder(OrderEntity orderEntity);
    OrderEntity orderToOrderEntity(Order order);

    @Mapping(source = "userProfileEntity", target = "userProfile")
    @Mapping(source = "orderEntitySet", target = "orderSet")
    User userEntityToUser(UserEntity userEntity);
    @Mapping(source = "userProfile", target = "userProfileEntity")
    @Mapping(source = "orderSet", target = "orderEntitySet")
    UserEntity userToUserEntity(User user);

    UserAddress userAddressEntityToUserAddress(UserAddressEntity userAddressEntity);
    UserAddressEntity userAddressToUserAddressEntity(UserAddress userAddress);

    @Mapping(source = "userAddressSet", target = "userAddressEntitySet")
    UserProfileEntity userProfileGetToUserProfileEntity(UserProfilePost userProfilePost);
    @Mapping(source = "userAddressEntitySet", target = "userAddressSet")
    UserProfileGet userProfileEntityToUserProfileGet(UserProfileEntity userProfileEntity);

//    @Mapping(source = "userAddressSet", target = "userAddressEntitySet")
//    UserProfileEntity userProfilePostToUserProfileEntity(UserProfilePost userProfilePost);
//    @Mapping(source = "userAddressEntitySet", target = "userAddressSet")
//    UserProfilePost userProfileEntityToUserProfilePost(UserProfileEntity userProfileEntity);
}
