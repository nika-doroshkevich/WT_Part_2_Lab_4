package by.nika_doroshkevich.service.validator.impl;

import by.nika_doroshkevich.service.validator.AbstractValidator;

public class HourValidatorImpl extends AbstractValidator {
    private static final String HOUR_REGEX = "^((1[0-9])|(0)|(2[0-3]))$";

    @Override
    protected String getRegex() {
        return HOUR_REGEX;
    }
}
