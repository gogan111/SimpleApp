package com.andrey.simpleApp.domain.validator;

import com.andrey.simpleApp.domain.User;

public class UserValidator implements Validator {
    private String nameError = null;
    private String surnameError = null;
    private String ageError = null;
    private String emailError = null;

    private boolean errors;

    public boolean hasErrors() {
        return errors;
    }

    public UserValidator() {
    }

    public UserValidator(User user) {
        validate(user);
    }

    @Override
    public void validate(User user) {
        if (checkName(user.getName())) {
            errors = true;
        }
        if (checkSurname(user.getSurname())) {
            errors = true;
        }
        if (checkAge(user.getAge())) {
            errors = true;
        }
        if (checkEmail(user.getEmail())) {
            errors = true;
        }
    }

    @Override
    public boolean checkName(String name) {
        boolean error = false;
        String reg = "^([A-Za-z]{1}[0-9A-Za-z]{0,30})";

        if (name.length() < 2) {
            nameError = "Your name is too short";
            error = true;
        } else if (!name.matches(reg)) {
            nameError = "Bad name";
            error = true;
        }

        return error;
    }

    @Override
    public boolean checkSurname(String surname) {
        boolean error = false;
        String reg = "^([A-Za-z]{1}[0-9A-Za-z]{0,30})";

        if (surname.length() < 2) {
            surnameError = "Your surname is too short";
            error = true;
        } else if (!surname.matches(reg)) {
            surnameError = "Bad surname";
            error = true;
        }

        return error;
    }

    @Override
    public boolean checkAge(int age) {
        boolean error = false;

        if (age < 1) {
            ageError = "Age should be higher then 0";
            error = true;
        } else if (age > 120) {
            ageError = "Your age is too high";
            error = true;
        }

        return error;
    }

    @Override
    public boolean checkEmail(String email) {
        boolean error = false;
        String reg = "^(([0-9A-Za-z]{1}[-0-9A-z\\.]{0,30}[0-9A-Za-z]?)@([-A-Za-z]{1,}\\.){1,}[-A-Za-z]{2,})$";

        if (!email.matches(reg)) {
            emailError = "Un correct email";
            error = true;
        }

        return error;
    }

    public String getNameError() {
        return nameError;
    }

    public String getSurnameError() {
        return surnameError;
    }

    public String getAgeError() {
        return ageError;
    }

    public String getEmailError() {
        return emailError;
    }
}
