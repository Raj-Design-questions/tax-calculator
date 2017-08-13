package com.hotels.tax.model.impl;

import com.hotels.tax.model.IProduct;
import com.hotels.tax.model.IReceipt;
import com.hotels.tax.util.CalculatorUtil;

import java.util.Map;

/**
 * Created by 212578960 on 8/12/2017.
 */
public class TaxCalculationReceipt implements IReceipt {

    StringBuilder textToPrint = new StringBuilder();
    Map<IProduct, Integer> products;

    public void setProductsList(Map<IProduct, Integer> products) {
        this.products = products;
    }

    public void print() {
        if(products == null){
            return;
        }
        printItems();
        addSalesTax();
        addTotalAmount();
    }

    public void printItems() {
        if(products == null){
            return;
        }
        for(Map.Entry<IProduct, Integer> entry : products.entrySet()){
            IProduct product = entry.getKey();
            Integer quantity = entry.getValue();
            if(quantity != null && quantity > 0){
                Float taxedPrice = product.getTaxedPrice();
                Float price = product.getPrice();
                Float totalPrice = (price + taxedPrice) * quantity;
                textToPrint.append(quantity).append(" ").append(product.getName()).append(" ").append(CalculatorUtil.format(totalPrice));
                textToPrint.append("\n");
            }
        }
    }

    public void addSalesTax() {
        if(products == null){
            return;
        }
        Float totalSalesTax = 0f;
        for(Map.Entry<IProduct, Integer> entry : products.entrySet()){
            IProduct product = entry.getKey();
            Integer quantity = entry.getValue();
            if(quantity != null && quantity > 0){
                Float taxedPrice = product.getTaxedPrice();
                totalSalesTax += taxedPrice * quantity;
            }
        }

        textToPrint.append("Sales Tax : ").append(CalculatorUtil.format(totalSalesTax)).append("\n");
    }

    public void addTotalAmount() {
        if(products == null){
            return;
        }
        Float total = 0f;
        for(Map.Entry<IProduct, Integer> entry : products.entrySet()){
            IProduct product = entry.getKey();
            Integer quantity = entry.getValue();
            if(quantity != null && quantity > 0) {
                Float taxedPrice = product.getTaxedPrice();
                Float price = product.getPrice();
                Float totalPrice = (price + taxedPrice) * quantity;
                total += totalPrice;
            }

        }

        textToPrint.append("Total : ").append(CalculatorUtil.format(total));
    }

    public StringBuilder getTextForPrint() {
        return textToPrint;
    }
}
