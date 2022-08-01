package com.example.parserlog.services.impl;

import com.example.parserlog.enums.TimeZones;
import com.example.parserlog.enums.Urls;
import com.example.parserlog.models.User;
import com.example.parserlog.services.MappingUserToDateTime;
import com.example.parserlog.services.SearchEngine;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class for search the best users
 */
@Service
@RequiredArgsConstructor
public class SearchEngineImpl implements SearchEngine {

    private final MappingUserToDateTime startsFile;
    private final MappingUserToDateTime finishesFile;

    /**
     * Method that returns the best players
     * @param limit - top users
     * @return List<User> - the best users
     */
    public List<User> getUsers(int limit) {
        Map<String, Pair<ZonedDateTime, ZonedDateTime>> map = convertToStartFinishPair(startsFile, finishesFile);
        return findUsers(limit, map);
    }

    /**
     * Method than search the best users
     * @param limit - top users
     * @param map - pair start finish times
     * @return List<User> - the best users
     */
    private List<User> findUsers(int limit, Map<String, Pair<ZonedDateTime, ZonedDateTime>> map) {

        return map.entrySet().stream()
                .map(e -> new User(e.getKey(), e.getValue().getLeft(), e.getValue().getRight()))
                .sorted((user1, user2) -> {
                    return Long.compare(user2.getDuration().getSeconds(), user1.getDuration().getSeconds());
                })
                .limit(limit)
                .collect(Collectors.toList());
    }

    /**
     * Method that matches the user with his race data
     * @param start data about starts
     * @param finish data about finish
     * @return Map<String, Pair<ZonedDateTime, ZonedDateTime>>
     */
    private Map<String, Pair<ZonedDateTime, ZonedDateTime>> convertToStartFinishPair(MappingUserToDateTime start,
                                                                                     MappingUserToDateTime finish) {
        Map<String, ZonedDateTime> startPairs = start.mapping(Urls.TAG_READ_START.getValue(),
                new ParseServiceImpl(TimeZones.TIME_ZONE_START.getValue()));
        Map<String, Pair<ZonedDateTime, ZonedDateTime>> userStartFinish = new HashMap<>();
        finish.mapping(Urls.TAG_READ_FINISH.getValue(),
                new ParseServiceImpl(TimeZones.TIME_ZONE_FINISH.getValue())).forEach((k, v) -> {
            if (v != null && startPairs.get(k) != null) {
                Pair<ZonedDateTime, ZonedDateTime> p = Pair.of(startPairs.get(k), v);
                userStartFinish.put(k, p);
            }
        });
        return userStartFinish;
    }
}
