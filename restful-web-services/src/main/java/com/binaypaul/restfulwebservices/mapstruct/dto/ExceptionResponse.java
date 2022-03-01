package com.binaypaul.restfulwebservices.mapstruct.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@ToString
public class ExceptionResponse {
    private Date exceptionDate;
    private String path;
    private String message;
    private String details;
}
