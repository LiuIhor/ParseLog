package com.example.parserlog.controllers;

import com.example.parserlog.DTO.UserDTO;
import com.example.parserlog.mapper.Mapper;
import com.example.parserlog.services.SearchEngine;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class controller {

    private final SearchEngine searchEngine;

    /**
     * Controller that shows top players
     * @param limit - param top users
     * @return List<UserDTO> - top users
     */
    @GetMapping("/top-users")
    public List<UserDTO> topUsers(@RequestParam(required=true,defaultValue="10") int limit) {
        return searchEngine.getUsers(limit).stream()
                .map(Mapper::toDto)
                .collect(Collectors.toList());
    }
}