package com.binaypaul.restfulwebservices.entity;

import com.binaypaul.restfulwebservices.mapstruct.dto.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_PROFILE")
public class UserProfileEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column
    private String email;

    @Column
    private String password;

    @Column(nullable = true, length = 160)
    private String bio;

    @OneToOne(mappedBy = "userProfileEntity", cascade = CascadeType.ALL)
    private UserEntity userEntity;

    @OneToMany(mappedBy ="userProfileEntity", cascade = CascadeType.ALL)
    private List<UserAddressEntity> userAddressEntitySet;
}