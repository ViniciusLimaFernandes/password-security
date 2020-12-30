package com.password.security.application.resources;

import com.password.security.application.domain.entity.PasswordStatus;
import com.password.security.application.resources.entity.PasswordDTO;
import com.password.security.application.service.PasswordValidatorService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/password")
public class PasswordValidatorResource {

    @Autowired
    PasswordValidatorService passwordValidatorService;

    @PostMapping("/validate")
    public ResponseEntity<PasswordStatus> validatePassword(@NonNull @RequestBody final PasswordDTO passwordDTO) {

        if (passwordDTO.isInvalidInput()) {
            log.error("Invalid input. The password cannot be null!");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(passwordValidatorService.isValidPasswordWithAllCriteria(passwordDTO));
    }
}
