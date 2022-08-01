package com.example.parserlog.services;

import org.apache.commons.lang3.tuple.Pair;

import java.time.ZonedDateTime;
import java.util.Optional;

public interface ParseService {

    Optional<Pair<String, ZonedDateTime>> parseLog(String line);

}