package com.binaypaul.restfulwebservices.mapstruct.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.Set;

@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserProfilePost extends UserProfile {
    @NonNull
    private String password;
}