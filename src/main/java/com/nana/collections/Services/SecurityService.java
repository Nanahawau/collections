package com.nana.collections.Services;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}


