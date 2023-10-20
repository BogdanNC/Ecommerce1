package Classes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    public BigDecimal value;
    public String currencyCode;

    /**
     * Converts any Number type to BigDecimal which will help with precise calculations
     * @param number The Number value to be converted
     * @return the value as a BigDecimal type
     */
    private BigDecimal convertToBigDecimal(Number number) {
        if (number instanceof Integer) {
            return new BigDecimal((Integer) number);
        } else if (number instanceof Float) {
            return new BigDecimal((Float) number);
        } else if (number instanceof Double) {
            return new BigDecimal((Double) number);
        } else {
            throw new IllegalArgumentException("Unsupported number type");
        }
    }

    /**
     * Converts any Number type to BigDecimal which will help with precise calculations
     * @param number The String value to be converted
     * @return the value as a BigDecimal type
     */
    private BigDecimal convertToBigDecimal(String stringValue) {
        try {
            return new BigDecimal(stringValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numeric format in the String");
        }
    }

    /**
     * The constructor for the Money Model
     * @param value The Number value
     * @param currencyCode The ISO 4217 currency code
     */
    private Money(Number value, String currencyCode) {
        this.value = convertToBigDecimal(value);
        this.currencyCode = currencyCode;
    }

    /**
     * The constructor for the Money Model
     * @param value The String value
     * @param currencyCode The ISO 4217 currency code
     */
    public Money(String value, String currencyCode) {
        this.value = convertToBigDecimal(value);
        this.currencyCode = currencyCode;
    }

    private Money(Number value, String currencyCode) {
        new Money(currencyCode, currencyCode);
    }

    /**
     * Adds a percentage to the current value from a Number input
     * @param percentage The percentage to be added
     * @return The result as a BigDecimal type
     */
    public BigDecimal addPercent(Number percentage) {
        BigDecimal percent = convertToBigDecimal(percentage);
        BigDecimal result = value.add(value.multiply(percent.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP)));
        return result;
    }

    /**
     * Adds a percentage to the current value from a String input
     * @param percentage The percentage to be added
     * @return The result as a BigDecimal type
     */
    public BigDecimal addPercent(String percentage) {
        BigDecimal percent = convertToBigDecimal(percentage);
        BigDecimal result = value.add(value.multiply(percent.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP)));
        return result;
    }

    /**
     * Subtracts the tax from the current value from a Number input
     * @param percentage The tax to be subtracted
     * @return The result as a BigDecimal type
     */
    public BigDecimal subtractTax(Number percentage) {
        BigDecimal tax = convertToBigDecimal(percentage);
        BigDecimal result = value.divide(BigDecimal.ONE.add(tax.divide(new BigDecimal(100))), 2, RoundingMode.HALF_UP);
        return result;
    }

    /**
     * Subtracts the tax from the current value from a String input
     * @param percentage The tax to be subtracted
     * @return The result as a BigDecimal type
     */
    public BigDecimal subtractTax(String percentage) {
        BigDecimal tax = convertToBigDecimal(percentage);
        BigDecimal result = value.divide(BigDecimal.ONE.add(tax.divide(new BigDecimal(100))), 2, RoundingMode.HALF_UP);
        return result;
    }

    /**
     * Subtracts a percentage to the current value from a Number input
     * @param percentage The percentage to be subtracted
     * @return The result as a BigDecimal type
     */
    public BigDecimal subtractPercentage(Number percentage) {
        BigDecimal percent = convertToBigDecimal(percentage);
        BigDecimal result = value.subtract(value.multiply(percent.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP)));
        return result;
    }


    /**
     * Subtracts a percentage to the current value from a String input
     * @param percentage The percentage to be subtracted
     * @return The result as a BigDecimal type
     */
    public BigDecimal subtractPercentage(String percentage) {
        BigDecimal percent = convertToBigDecimal(percentage);
        BigDecimal result = value.subtract(value.multiply(percent.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP)));
        return result;
    }
}
