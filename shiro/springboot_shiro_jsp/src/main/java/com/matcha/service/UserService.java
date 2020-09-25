package com.matcha.service;

import com.matcha.entity.User;

public interface UserService {

    void register(User user);

    User findByUsername(String username);
}
