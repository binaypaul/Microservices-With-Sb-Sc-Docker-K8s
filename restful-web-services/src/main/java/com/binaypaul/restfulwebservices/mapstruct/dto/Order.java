package com.binaypaul.restfulwebservices.mapstruct.dto;

import lombok.*;

import java.util.Date;

@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private long id;
    private Date date;
}
