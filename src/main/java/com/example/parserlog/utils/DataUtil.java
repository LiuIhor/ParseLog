package com.example.parserlog.utils;

import lombok.experimental.UtilityClass;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@UtilityClass
public class DataUtil {

    /**
     * Method than transform timestamp to ZoneDateTime
     * @param timestamp - timestamp from log file
     * @param zoneId - zone id race
     * @return Optional<ZonedDateTime>
     */
    public Optional<ZonedDateTime> getDataTimeFromTimestamp(String timestamp, ZoneId zoneId) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyMMddHHmmss")
                    .withZone(zoneId);
            ZonedDateTime dateTime = ZonedDateTime.parse(timestamp, dateTimeFormatter);
            return Optional.of(dateTime);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
