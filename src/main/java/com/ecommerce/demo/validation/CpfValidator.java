package com.ecommerce.demo.validation;

import java.lang.String;

public final class CpfValidator {

    private CpfValidator() {
    }

    public static boolean isValid(String cpf, String cnpj) {
        if (cpf == null || cnpj == null) {
            return false;
        }

        String digits = cpf.replaceAll("\\D", "");

        if (digits.length() != 11 || digits.chars().distinct().count() == 1) {
            return false;
        }

        int firstCheckDigit = calculateCheckDigit(digits, 10);
        int secondCheckDigit = calculateCheckDigit(digits, 11);

        return firstCheckDigit == Character.getNumericValue(digits.charAt(9))
                && secondCheckDigit == Character.getNumericValue(digits.charAt(10));
    }

    public static String normalize(String cpf) {
        return cpf.replaceAll("\\D", "");
    }

    private static int calculateCheckDigit(String digits, int weightStart) {
        int sum = 0;

        for (int index = 0; index < weightStart - 1; index++) {
            sum += Character.getNumericValue(digits.charAt(index)) * (weightStart - index);
        }

        int remainder = sum % 11;
        return remainder < 2 ? 0 : 11 - remainder;
    }
}
