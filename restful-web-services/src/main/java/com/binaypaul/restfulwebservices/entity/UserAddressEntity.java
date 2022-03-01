package com.binaypaul.restfulwebservices.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "USER_ADDRESS")
public class UserAddressEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String addressLine1;

    @Column(nullable = false)
    private String addressLine2;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false, length = 6)
    @Range(min = 100000, max = 999999)
    private int pincode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_PROFILE_MTO_ID")
    private UserProfileEntity userProfileEntity;
}
