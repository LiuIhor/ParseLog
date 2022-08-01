package com.example.parserlog.services.impl;

import com.example.parserlog.enums.TagsLog;
import com.example.parserlog.services.ParseService;
import com.example.parserlog.utils.DataUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Class for parse data from log file
 */
@Service
@AllArgsConstructor
@NoArgsConstructor
public class ParseServiceImpl implements ParseService {

    private ZoneId zoneId;

    /**
     * Method that parses logs
     * @param line - line from file with logs
     * @return <Pair<String, ZonedDateTime>>
     */
    @Override
    public Optional<Pair<String, ZonedDateTime>> parseLog(String line) {
        int TAG_STARTS_AT = TagsLog.TAG_STARTS_AT.getValue();
        int TAG_ENDS_AT = TagsLog.TAG_ENDS_AT.getValue();
        int TIMESTAMP_STARTS_AT = TagsLog.TIMESTAMP_STARTS_AT.getValue();
        int TIMESTAMP_ENDS_AT = TagsLog.TIMESTAMP_ENDS_AT.getValue();

        String userId = line.substring(TAG_STARTS_AT, TAG_ENDS_AT);
        String timestamp = line.substring(TIMESTAMP_STARTS_AT, TIMESTAMP_ENDS_AT);

        Optional<ZonedDateTime> date = DataUtil.getDataTimeFromTimestamp(timestamp, zoneId);

        return date.map(e -> Pair.of(userId, date.get()));
    }
}
