package com.example.librarymanagement.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private String name;

    // ✅ Default constructor
    public UserDTO() {}

    // ✅ Parameterized constructor
    public UserDTO(String name) {
        this.name = name;
    }

    // ✅ Getter
    public String getName() {
        return name;
    }

    // ✅ Setter
    public void setName(String name) {
        this.name = name;
    }

    // ✅ toString() for debugging
    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
