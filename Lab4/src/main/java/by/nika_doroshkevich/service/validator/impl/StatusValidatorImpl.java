package by.nika_doroshkevich.service.validator.impl;

import by.nika_doroshkevich.service.validator.AbstractValidator;

public class StatusValidatorImpl extends AbstractValidator {
    private static final String STATUS_REGEX = "^(.{1,15})$";

    @Override
    protected String getRegex() {
        return STATUS_REGEX;
    }
}
