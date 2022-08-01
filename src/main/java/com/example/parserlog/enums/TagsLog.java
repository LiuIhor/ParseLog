package com.example.parserlog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TagsLog {
    TAG_STARTS_AT(4),
    TAG_ENDS_AT(16),
    TIMESTAMP_STARTS_AT(20),
    TIMESTAMP_ENDS_AT(32);

    @Getter
    private final int value;
}