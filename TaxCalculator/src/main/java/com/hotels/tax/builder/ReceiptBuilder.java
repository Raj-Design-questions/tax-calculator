package com.hotels.tax.builder;

import com.hotels.tax.model.IProduct;
import com.hotels.tax.model.IReceipt;
import com.hotels.tax.model.impl.TaxCalculationReceipt;

import java.util.Map;

/**
 * Created by 212578960 on 8/13/2017.
 */
public class ReceiptBuilder {

    IReceipt receipt = new TaxCalculationReceipt();

    private ReceiptBuilder(Map<IProduct, Integer> products) {
        receipt.setProductsList(products);
    }

    public static ReceiptBuilder createReceiptBuilder(Map<IProduct, Integer> products){
        return new ReceiptBuilder(products);
    }

    public ReceiptBuilder withItemTaxAndTotal(){
        receipt.print();
        return this;
    }

    public ReceiptBuilder withItems(){
        receipt.printItems();
        return this;
    }

    public ReceiptBuilder withSalesTax(){
        receipt.addSalesTax();
        return this;
    }

    public ReceiptBuilder withTotalAmount(){
        receipt.addTotalAmount();
        return this;
    }

    public StringBuilder build(){
        return receipt.getTextForPrint();
    }
}
