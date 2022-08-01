package com.example.parserlog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZoneId;

@AllArgsConstructor
public enum TimeZones {
    TIME_ZONE_START(ZoneId.of("UTC")),
    TIME_ZONE_FINISH(ZoneId.of("Europe/Kiev"));

    @Getter
    private final ZoneId value;
}