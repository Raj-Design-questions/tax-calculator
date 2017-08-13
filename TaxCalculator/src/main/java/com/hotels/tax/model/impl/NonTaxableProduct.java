package com.hotels.tax.model.impl;

/**
 * Created by 212578960 on 8/6/2017.
 */
public abstract class NonTaxableProduct extends Product {

    private static Float tax = 0.0F;
    public NonTaxableProduct(String name, String code, Float price) {
        super(name, code, price, tax);
    }
}
