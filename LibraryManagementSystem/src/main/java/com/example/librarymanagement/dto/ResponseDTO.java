package com.example.librarymanagement.dto;

import java.io.Serializable;

public class ResponseDTO implements Serializable {
    private String message;

    // ✅ Default constructor
    public ResponseDTO() {}

    // ✅ Parameterized constructor
    public ResponseDTO(String message) {
        this.message = message;
    }

    // ✅ Getter
    public String getMessage() {
        return message;
    }

    // ✅ Setter
    public void setMessage(String message) {
        this.message = message;
    }

    // ✅ toString() for debugging
    @Override
    public String toString() {
        return "ResponseDTO{" +
                "message='" + message + '\'' +
                '}';
    }
}
