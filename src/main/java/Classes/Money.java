package Classes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    public Number value;
    public String currencyCode;

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

    private BigDecimal convertToBigDecimal(String stringValue) {
        try {
            return new BigDecimal(stringValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numeric format in the String");
        }
    }

    public Money(Number value, String currencyCode) {
        this.value = value;
        this.currencyCode = currencyCode;
    }

    public BigDecimal addPercent(Number percentage) {
        BigDecimal currentValue = convertToBigDecimal(value);
        BigDecimal percent = convertToBigDecimal(percentage);
        BigDecimal result = currentValue.add(currentValue.multiply(percent.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP)));
        return result;
    }

    public BigDecimal addPercent(String percentage) {
        BigDecimal currentValue = convertToBigDecimal(value);
        BigDecimal percent = convertToBigDecimal(percentage);
        BigDecimal result = currentValue.add(currentValue.multiply(percent.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP)));
        return result;
    }

    public BigDecimal subtractTax(Number percentage) {
        BigDecimal currentValue = convertToBigDecimal(value);
        BigDecimal tax = convertToBigDecimal(percentage);
        BigDecimal result = currentValue.divide(BigDecimal.ONE.add(tax.divide(new BigDecimal(100))), 2, RoundingMode.HALF_UP);
        return result;
    }

    public BigDecimal subtractTax(String percentage) {
        BigDecimal currentValue = convertToBigDecimal(value);
        BigDecimal tax = convertToBigDecimal(percentage);
        BigDecimal result = currentValue.divide(BigDecimal.ONE.add(tax.divide(new BigDecimal(100))), 2, RoundingMode.HALF_UP);
        return result;
    }

    public BigDecimal subtractPercentage(Number percentage) {
        BigDecimal currentValue = convertToBigDecimal(value);
        BigDecimal percent = convertToBigDecimal(percentage);
        BigDecimal result = currentValue.subtract(currentValue.multiply(percent.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP)));
        return result;
    }

    public BigDecimal subtractPercentage(String percentage) {
        BigDecimal currentValue = convertToBigDecimal(value);
        BigDecimal percent = convertToBigDecimal(percentage);
        BigDecimal result = currentValue.subtract(currentValue.multiply(percent.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP)));
        return result;
    }
}
