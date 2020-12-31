package com.password.security.application.domain.rules;

import com.password.security.application.domain.interfaces.PasswordRulesInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HasAtLeastOneSpecialCharacter implements PasswordRulesInterface {
    @Override
    public boolean verify(String password) {
        final String acceptedSpecialCharacters = "!|@|#|$|%|^|&|*|(|)|\\-|+";

        final String SpecialCharactersBlacklist = "=|'|\"|\\\\||;|:|?|\\/|~|`|´|§|<|>|,|\\" +
                ".|\\[|\\]|_|¨|¹|²|³|£|¢|¬|º|ª|°";

        final String atLeastOneSpecialCharacterRegex =
                "^(?=.*[" + acceptedSpecialCharacters + "])(?!.*[" + SpecialCharactersBlacklist + "]).*$";

        log.info("Checking if the password has at least one special character");

        return password.matches(atLeastOneSpecialCharacterRegex);
    }
}
