package com.password.security.application.domain.interfaces;

public interface PasswordCriteria {

    public Boolean hasAtLeastOneUpperCaseLetter(String password);

    public Boolean hasAtLeastOneLowerCaseLetter(String password);

    public Boolean hasAtLeastOneDigit(String password);

    public Boolean hasAtLeastOneSpecialCharacter(String password);

    public Boolean hasAtLeastNineCharacters(String password);

    public Boolean haveNonRepeatingCharacters(String password);

    public Boolean haveNonSpaces(String password);
}
