package com.hotels.tax.model.impl;

import com.hotels.tax.util.CalculatorUtil;

/**
 * Created by 212578960 on 8/13/2017.
 */
public class CompactDisc extends ComputerAccessory{

    private Float additionalTax = 1.25f;

    public CompactDisc(String name, String code, Float price) {
        super(name, code, price);
    }

    @Override
    public Float getTaxedPrice(){
        Float normalTax = super.getTaxedPrice();
        return CalculatorUtil.roundOf(normalTax + additionalTax);
    }
}
