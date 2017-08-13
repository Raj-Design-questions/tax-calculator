package com.hotels.tax.service;

import com.hotels.tax.exception.ProductNotFoundException;
import com.hotels.tax.model.IProduct;

/**
 * Created by 212578960 on 8/12/2017.
 */
public interface IDataService {
    IProduct getProductByCode(String code) throws ProductNotFoundException;
    void addProduct(String code, IProduct product);
    void removeProduct(String code);
}
