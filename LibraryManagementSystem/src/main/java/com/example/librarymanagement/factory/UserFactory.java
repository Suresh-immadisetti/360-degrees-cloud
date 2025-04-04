package com.example.librarymanagement.factory;

import com.example.librarymanagement.model.User;

public class UserFactory {
    public static User createUser(String name) {
        return new User(name);
    }
}
