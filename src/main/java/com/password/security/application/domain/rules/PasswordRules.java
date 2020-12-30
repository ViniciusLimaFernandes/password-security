package com.password.security.application.domain.rules;

import com.password.security.application.domain.interfaces.PasswordCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Slf4j
@Component
public class PasswordRules implements PasswordCriteria {

    @Override
    public Boolean hasAtLeastOneUpperCaseLetter(final String password) {
        final String atLeastOneUpperCaseLetterRegex = "^(?=.*[A-Z]).*$";

        return password.matches(atLeastOneUpperCaseLetterRegex);
    }

    @Override
    public Boolean hasAtLeastOneLowerCaseLetter(final String password) {
        final String atLeastOneLowerCaseLetterRegex = "^(?=.*[a-z]).*$";

        return password.matches(atLeastOneLowerCaseLetterRegex);
    }

    @Override
    public Boolean hasAtLeastOneDigit(final String password) {
        final String atLeastOneDigitRegex = "^(?=.*[0-9]).*$";

        return password.matches(atLeastOneDigitRegex);
    }

    @Override
    public Boolean hasAtLeastOneSpecialCharacter(final String password) {
        final String atLeastOneSpecialCharacterRegex = "^(?=.*[!|@|#|$|%|^|&|*|(|)|\\-|+]).*$";

        return password.matches(atLeastOneSpecialCharacterRegex);
    }

    @Override
    public Boolean hasAtLeastNineCharacters(final String password) {
        final String atLeastOneDigitRegex = "^(?=^.{9,}).*$";

        return password.matches(atLeastOneDigitRegex);
    }


    @Override
    public Boolean haveNonRepeatingCharacters(final String password) {
        final String haveNonRepeatingCharactersRegex = "^(?!.*(.).*\\1).*$";

        final Pattern haveNonRepeatingCharactersPattern = Pattern.compile(haveNonRepeatingCharactersRegex, Pattern.CASE_INSENSITIVE);

        return haveNonRepeatingCharactersPattern.matcher(password).find();
    }

    @Override
    public Boolean haveNonSpaces(final String password) {
        final String haveNonSpacesRegex = "^(?!.*\\h).*$";

        return password.matches(haveNonSpacesRegex);
    }
}
