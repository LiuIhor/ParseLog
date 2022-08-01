package com.example.parserlog.services.impl;

import com.example.parserlog.services.MappingUserToDateTime;
import com.example.parserlog.services.ParseService;
import com.example.parserlog.utils.ReadLogsUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Class for mapping user to ZonedDateTime
 */
@Service
public class MappingUserToDateTimeImpl implements MappingUserToDateTime {
    /**
     * Method that matches the user with the ZonedDateTime
     * @param url - url to file with logs
     * @param parseService - Object for parsing logs
     * @return Map<String, ZonedDateTime> - User id to ZonedDateTime
     */
    @Override
    public Map<String, ZonedDateTime> mapping(String url, ParseService parseService) {
        Map<String, ZonedDateTime> users = new HashMap<>();
        try (Stream<String> lines = new BufferedReader(ReadLogsUtil.read(url)).lines()) {
            lines.forEach(line -> {
                Pair<String, ZonedDateTime> l = parseService.parseLog(line).orElse(null);
                if (!users.containsKey(l != null ? l.getLeft() : null)) {
                    users.put(l != null ? l.getLeft() : null, l != null ? l.getRight() : null);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
