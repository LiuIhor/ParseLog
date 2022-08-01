package com.example.parserlog.DTO;

import lombok.Data;

import java.time.Duration;
import java.time.ZonedDateTime;

@Data
public class UserDTO {
    private String id;
    private ZonedDateTime startDateTime;
    private ZonedDateTime finishDateTime;
    private Duration duration;
    private long durationInSec;
}