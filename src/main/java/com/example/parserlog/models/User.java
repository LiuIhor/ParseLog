package com.example.parserlog.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.Duration;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class User {
    private String id;
    private ZonedDateTime startDateTime;
    private ZonedDateTime finishDateTime;
    @Getter
    private Duration duration;


    public User(String id, ZonedDateTime startDateTime, ZonedDateTime finishDateTime) {
        this.id = id;
        this.startDateTime = startDateTime;
        this.finishDateTime = finishDateTime;
        this.duration = Duration.between(startDateTime, finishDateTime);
    }

    @Override
    public String toString() {
        return "User{" +
                "id = '" + id + '\'' +
                ", startDate = " + startDateTime +
                ", endDate = " + finishDateTime +
                ", duration = " + duration +
                ", duration in sec" + duration.getSeconds() +
                '}';
    }
}
