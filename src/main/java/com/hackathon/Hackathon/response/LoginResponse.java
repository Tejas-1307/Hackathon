package com.hackathon.Hackathon.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {

    String message;

    Boolean status;

    public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }

    public LoginResponse() {
    }
}
