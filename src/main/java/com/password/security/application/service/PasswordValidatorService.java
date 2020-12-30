package com.password.security.application.service;

import com.password.security.application.domain.entity.PasswordStatus;
import com.password.security.application.domain.interfaces.PasswordCriteria;
import com.password.security.application.resources.entity.PasswordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordValidatorService {

    @Autowired
    PasswordCriteria passwordCriteria;

    public PasswordStatus isValidPasswordWithAllCriteria(final PasswordDTO passwordDTO) {
        final String password = passwordDTO.getPassword();

        boolean isValidStatus = false;

        if (passwordCriteria.hasAtLeastNineCharacters(password) &&
                passwordCriteria.hasAtLeastOneDigit(password) &&
                passwordCriteria.hasAtLeastOneLowerCaseLetter(password) &&
                passwordCriteria.hasAtLeastOneUpperCaseLetter(password) &&
                passwordCriteria.hasAtLeastOneSpecialCharacter(password) &&
                passwordCriteria.haveNonRepeatingCharacters(password) &&
                passwordCriteria.haveNonSpaces(password)) {

            isValidStatus = true;
        }

        return PasswordStatus.builder()
                .isValid(isValidStatus)
                .build();
    }
}
