package com.gpu.receiptgenerator.model;



import java.util.stream.Stream;

import com.gpu.receiptgenerator.utils.MathUtils;

public class Item {

    private String name;
    private int quantity;
    private double price;
    private double basicSalesTaxAmount;
    private double additionalSalesTaxAmount;

    public Item(String quantity, String name, String price) {
        this.name = name;
        this.quantity = Integer.valueOf(quantity);
        this.price = Double.valueOf(price);
    }

    public double getFinalPrice() {
        double finalPrice = quantity * price + getTaxAmount();
		return MathUtils.roundOffAmount(finalPrice);
    }

    public double getTaxAmount() {
        double taxAmount = quantity * (basicSalesTaxAmount + additionalSalesTaxAmount);
		return MathUtils.roundOffTax(taxAmount);
    }

    public boolean isImported() {
        return name.contains("imported");
    }

    public boolean isExempted() {
        return Stream.of("book", "chocolate", "pill")
                .anyMatch(exemptedItem -> name.contains(exemptedItem));
    }

    public void setBasicSalesTaxAmount(double salesTaxPercent) {
        basicSalesTaxAmount = price * salesTaxPercent;
    }

    public void setAdditionalSalesTax(double additionalSalesTaxPercent) {
        additionalSalesTaxAmount = price * additionalSalesTaxPercent;
    }

    public String toString() {
        return String.valueOf(quantity) +
                " " +
                name +
                " : " +
                getFinalPrice();
    }
}

