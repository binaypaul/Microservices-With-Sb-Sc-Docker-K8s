package com.binaypaul.restfulwebservices.mapstruct.dto;

import lombok.*;
import org.hibernate.validator.constraints.Range;

@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserAddress {
    private long id;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    @Range(min = 100000, max = 999999)
    private int pincode;
}
