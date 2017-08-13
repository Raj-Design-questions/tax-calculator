package com.hotels.tax.model;

/**
 * Created by 212578960 on 8/6/2017.
 */
public interface IProduct {
    String getCode();
    void setCode(String code);
    String getName();
    void setName(String name);
    Float getPrice();
    void setPrice(Float quantity);
    Float getTaxedPrice();
}
