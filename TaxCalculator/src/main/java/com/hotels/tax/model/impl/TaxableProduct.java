package com.hotels.tax.model.impl;

/**
 * Created by 212578960 on 8/6/2017.
 */
public abstract class TaxableProduct extends Product {

    private static Float tax = 17.5F;
    public TaxableProduct(String name, String code, Float price) {
        super(name, code, price, tax);
    }
}
