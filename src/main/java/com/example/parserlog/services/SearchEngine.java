package com.example.parserlog.services;

import com.example.parserlog.models.User;

import java.util.List;

public interface SearchEngine {

    List<User> getUsers(int limit);

}