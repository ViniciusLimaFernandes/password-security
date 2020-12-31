package com.password.security.application.domain.mappers;

import com.password.security.application.domain.enumeration.Criteria;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PasswordRulesMapper {

    public boolean isValid(String password, Criteria... criterias) {
        
        for (Criteria criteria : criterias) {
            boolean isAnInvalidPassword = !criteria.getPasswordRulesInterface().verify(password);

            if (isAnInvalidPassword) {
                return false;
            }
        }

        return true;
    }

}
