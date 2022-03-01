package com.binaypaul.restfulwebservices.mapstruct.dto;

import lombok.*;

import java.util.Set;

@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private long id;
    private UserProfile userProfile;
    private Set<Order> orderSet;
}
