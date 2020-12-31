package com.password.security.application.resources.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class PasswordDTO {

    private String password;

    public boolean isInvalidInput() {
        return Objects.isNull(this.password);
    }
}
