package com.password.security.application.resources.entity;

import lombok.Getter;

import java.util.Objects;

@Getter
public class PasswordDTO {

    private String password;

    public boolean isInvalidInput() {
        return Objects.isNull(this.password);
    }
}
