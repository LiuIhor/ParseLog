package com.example.parserlog.services;

import java.time.ZonedDateTime;
import java.util.Map;

public interface MappingUserToDateTime {

    Map<String, ZonedDateTime> mapping(String url, ParseService parseService);

}