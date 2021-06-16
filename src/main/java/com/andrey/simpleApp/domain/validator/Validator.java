package com.andrey.simpleApp.domain.validator;

import com.andrey.simpleApp.domain.User;

public interface Validator {
    boolean hasErrors();

    void validate(User user);

    boolean checkEmail(String email);

    boolean checkName(String name);

    boolean checkSurname(String surname);

    boolean checkAge(int age);
}
