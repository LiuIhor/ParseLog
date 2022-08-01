package com.example.parserlog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Urls {
    TAG_READ_START("src/main/resources/logs/tag_read_start.log"),
    TAG_READ_FINISH("src/main/resources/logs/tag_reads_finish.log");

    @Getter
    private final String value;
}