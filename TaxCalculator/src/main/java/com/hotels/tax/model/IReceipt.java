package com.hotels.tax.model;

import com.hotels.tax.model.IProduct;

import java.util.List;
import java.util.Map;

/**
 * Created by 212578960 on 8/6/2017.
 */
public interface IReceipt {
    void setProductsList(Map<IProduct, Integer> products);

    void print();

    void printItems();

    void addSalesTax();

    void addTotalAmount();

    StringBuilder getTextForPrint();
}
