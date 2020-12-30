package com.password.security.application.service;

import com.password.security.application.domain.entity.PasswordStatus;
import com.password.security.application.domain.interfaces.PasswordCriteria;
import com.password.security.application.resources.entity.PasswordDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PasswordValidatorService {

    @Autowired
    PasswordCriteria passwordCriteria;

    public PasswordStatus isValidPasswordWithAllCriteria(final PasswordDTO passwordDTO) {
        final String password = passwordDTO.getPassword();

        log.info("Checking if the password is valid following all criteria");

        boolean isValidStatus = false;

        if (passwordCriteria.hasAtLeastNineCharacters(password) &&
                passwordCriteria.hasAtLeastOneDigit(password) &&
                passwordCriteria.hasAtLeastOneLowerCaseLetter(password) &&
                passwordCriteria.hasAtLeastOneUpperCaseLetter(password) &&
                passwordCriteria.hasAtLeastOneSpecialCharacter(password) &&
                passwordCriteria.haveNonRepeatingCharacters(password) &&
                passwordCriteria.haveNonSpaces(password)) {

            isValidStatus = true;

            log.info("The password matches with all criteria!");

        } else log.info("The password doesn't fill all criteria");

        return PasswordStatus.builder()
                .isValid(isValidStatus)
                .build();
    }
}
