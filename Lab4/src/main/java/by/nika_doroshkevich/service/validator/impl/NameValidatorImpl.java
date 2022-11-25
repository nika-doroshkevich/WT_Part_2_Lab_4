package by.nika_doroshkevich.service.validator.impl;

import by.nika_doroshkevich.service.validator.AbstractValidator;

public class NameValidatorImpl extends AbstractValidator {
    private static final String NAME_REGEX = "^[A-ZА-Я]{1}[A-zА-я]{2,29}$";

    @Override
    protected String getRegex() {
        return NAME_REGEX;
    }
}
