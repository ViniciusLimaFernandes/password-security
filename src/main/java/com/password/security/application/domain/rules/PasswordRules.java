package com.password.security.application.domain.rules;

import com.password.security.application.domain.interfaces.PasswordCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Slf4j
@Component
public class PasswordRules implements PasswordCriteria {

    @Override
    public boolean hasAtLeastOneUpperCaseLetter(final String password) {
        final String atLeastOneUpperCaseLetterRegex = "^(?=.*[A-Z]).*$";

        log.info("Checking if the password has at least one uppercase letter");

        return password.matches(atLeastOneUpperCaseLetterRegex);
    }

    @Override
    public boolean hasAtLeastOneLowerCaseLetter(final String password) {
        final String atLeastOneLowerCaseLetterRegex = "^(?=.*[a-z]).*$";

        log.info("Checking if the password has at least one lowercase letter");

        return password.matches(atLeastOneLowerCaseLetterRegex);
    }

    @Override
    public boolean hasAtLeastOneDigit(final String password) {
        final String atLeastOneDigitRegex = "^(?=.*[0-9]).*$";

        log.info("Checking if the password has at least one digit");

        return password.matches(atLeastOneDigitRegex);
    }

    @Override
    public boolean hasAtLeastOneSpecialCharacter(final String password) {
        final String atLeastOneSpecialCharacterRegex = "^(?=.*[!|@|#|$|%|^|&|*|(|)|\\-|+]).*$";

        log.info("Checking if the password has at least one special character");

        return password.matches(atLeastOneSpecialCharacterRegex);
    }

    @Override
    public boolean hasAtLeastNineCharacters(final String password) {
        final String atLeastOneDigitRegex = "^(?=^.{9,}).*$";

        log.info("Checking if the password has at least nine characters");

        return password.matches(atLeastOneDigitRegex);
    }


    @Override
    public boolean haveNonRepeatingCharacters(final String password) {
        final String haveNonRepeatingCharactersRegex = "^(?!.*(.).*\\1).*$";

        log.info("Checking if the password doesn't repeat characters");

        final Pattern haveNonRepeatingCharactersPattern = Pattern.compile(haveNonRepeatingCharactersRegex, Pattern.CASE_INSENSITIVE);

        return haveNonRepeatingCharactersPattern.matcher(password).find();
    }

    @Override
    public boolean haveNonSpaces(final String password) {
        final String haveNonSpacesRegex = "^(?!.*\\h).*$";

        log.info("Checking if the password doesn't have spaces");

        return password.matches(haveNonSpacesRegex);
    }
}
