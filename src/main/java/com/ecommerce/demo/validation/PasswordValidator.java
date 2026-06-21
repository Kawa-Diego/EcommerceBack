package com.ecommerce.demo.validation;

import java.util.regex.Pattern;

public final class PasswordValidator {

    private static final Pattern STRONG_PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$"
    );

    private PasswordValidator() {
    }

    public static boolean isStrong(String password) {
        return password != null && STRONG_PASSWORD_PATTERN.matcher(password).matches();
    }
}
