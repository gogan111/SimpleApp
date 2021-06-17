package com.andrey.simpleApp.domain.validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserValidatorTest {
    Validator validator;

    @Before
    public void createValidator() {
        validator = new UserValidator();
    }
    @Test
    public void hasErrorMessages() {
        Assert.assertFalse(validator.hasErrors());
    }

    @Test
    public void checkCorrectName() {
        String[] names = {"John", "Asdjfhasd", "asdjfgvsd"};
        for (String name : names) {
            Assert.assertFalse(validator.checkName(name));
        }
    }

    @Test
    public void checkUnCorrectName() {
        String[] names = { "Ш", "123123123312", "Имя","R"};
        for (String name : names) {
            Assert.assertTrue(validator.checkName(name));
        }
    }

    @Test
    public void checkCorrectSurname() {
        String[] surnames = {"Dou", "Wayn", "asdasdsd"};
        for (String surname : surnames) {
            Assert.assertFalse(validator.checkName(surname));
        }
        Assert.assertFalse(validator.hasErrors());
    }

    @Test
    public void checkUnCorrectSurname() {
        String[] surnames = {"D", "  Wayn  ","...Wayn", "Айфон", "...2asd"};
        for (String surname : surnames) {
            Assert.assertTrue(validator.checkName(surname));
        }
    }

    @Test
    public void checkCorrectAge() {
        int [] ages = {1, 10,99,120};
        for (int age : ages) {
            Assert.assertFalse(validator.checkAge(age));
        }
    }
    @Test
    public void checkUnCorrectAge() {
        int [] ages = {-1, 0,121, 999};
        for (int age : ages) {
            Assert.assertTrue(validator.checkAge(age));
        }
    }

    @Test
    public void checkCorrectEmail() {
        String[] surnames = {"Dou@mains.coms", "example@i.ua"};
        for (String surname : surnames) {
            Assert.assertFalse(validator.checkEmail(surname));
        }
        Assert.assertFalse(validator.hasErrors());
    }

    @Test
    public void checkUnCorrectEmail() {
        String[] emails = {
                "adsdasd", "хорошаяПочта@main.ru", "  mail@mail.com",
                "ail@com", "vfil @mail.com", "mail@.com","mail@sa.m"
        };

        for (String email : emails) {
            Assert.assertTrue(validator.checkEmail(email));
        }
    }
}