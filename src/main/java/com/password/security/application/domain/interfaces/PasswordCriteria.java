package com.password.security.application.domain.interfaces;

public interface PasswordCriteria {

    public boolean hasAtLeastOneUpperCaseLetter(String password);

    public boolean hasAtLeastOneLowerCaseLetter(String password);

    public boolean hasAtLeastOneDigit(String password);

    public boolean hasAtLeastOneSpecialCharacter(String password);

    public boolean hasAtLeastNineCharacters(String password);

    public boolean haveNonRepeatingCharacters(String password);

    public boolean haveNonSpaces(String password);
}
