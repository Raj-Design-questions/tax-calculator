package com.hotels.tax.service;

import java.util.Map;

/**
 * Created by 212578960 on 8/13/2017.
 */
public interface ITaxCalculator {
    String getTaxCalculatedReceipt(Map<String, Integer> products);
}
