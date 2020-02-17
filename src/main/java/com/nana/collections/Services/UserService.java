package com.nana.collections.Services;

import com.nana.collections.Models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

}
