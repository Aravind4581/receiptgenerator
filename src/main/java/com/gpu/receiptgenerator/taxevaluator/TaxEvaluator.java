package com.gpu.receiptgenerator.taxevaluator;

import com.gpu.receiptgenerator.model.Item;

public class TaxEvaluator {


    private static final double SALES_TAX_PERCENT = 0.10;
    private static final double ADDITIONAL_SALES_TAX_PERCENT = 0.05;

    public static void applyTaxes(Item item) {
        if (!item.isExempted()) {
            item.setBasicSalesTaxAmount(SALES_TAX_PERCENT);
        }

        if (item.isImported()) {
            item.setAdditionalSalesTax(ADDITIONAL_SALES_TAX_PERCENT);
        }
    }
}