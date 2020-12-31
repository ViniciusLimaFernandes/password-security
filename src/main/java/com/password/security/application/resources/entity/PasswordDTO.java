package com.password.security.application.resources.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class PasswordDTO {

    private String password;

    public boolean isInvalidInput() {
        return Objects.isNull(this.password);
    }
}
