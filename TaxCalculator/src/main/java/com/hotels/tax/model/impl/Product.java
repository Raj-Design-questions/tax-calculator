package com.hotels.tax.model.impl;

import com.hotels.tax.model.IProduct;
import com.hotels.tax.util.CalculatorUtil;

/**
 * Created by 212578960 on 8/6/2017.
 */
public abstract class Product implements IProduct {
    private String name;
    private String code;
    private Float  price;
    private Float taxInPercentage;

    public Product(String name, String code, Float  price, Float taxInPercentage){
        this.name = name;
        this.code = code;
        this.price = price;
        this.taxInPercentage = taxInPercentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTaxedPrice(){
        if(taxInPercentage == 0.0f){
            return 0.0f;
        }
        Float tax = (price * taxInPercentage)/100;

        return CalculatorUtil.roundToMultipleOfFive(tax);
    }
}
