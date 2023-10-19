package Classes;

import java.math.BigDecimal;

import Classes.Money;

// TODO remove currencyCode as we will get that from somewhere else most likely
public class ProductPrice {
    public BigDecimal price;
    public BigDecimal priceBeforeTax;
    public String currencyCode;

    /**
     * Returns the ProductPrice model
     * @param value The Number value representing the price of the product
     * @param currencyCode The ISO 4217 currency code
     * @param percentage The tax percentage applied
     */
    public ProductPrice(Number value, String currencyCode, Number percentage) {
        Money money = new Money(value, currencyCode);
        this.price = money.value;
        this.priceBeforeTax = money.subtractTax(percentage);
    }

    /**
     * Returns the ProductPrice model
     * @param value The String value representing the price of the product
     * @param currencyCode The ISO 4217 currency code
     * @param percentage The tax percentage applied
     */
    public ProductPrice(String value, String currencyCode, String percentage) {
        Money money = new Money(value, currencyCode);
        this.price = money.value;
        this.priceBeforeTax = money.subtractTax(percentage);
    }
}
