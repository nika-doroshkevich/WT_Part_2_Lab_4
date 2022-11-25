package by.nika_doroshkevich.service.validator.impl;

import by.nika_doroshkevich.service.validator.AbstractValidator;

public class PriceValidatorImpl extends AbstractValidator {
    private static final String PRICE_REGEX = "^(([1-9]\\d*\\.\\d+)|(0[1-9]*\\.\\d+)|(\\d\\.\\d+)|(0)|([1-9]\\d*))$";

    @Override
    protected String getRegex() {
        return PRICE_REGEX;
    }
}