package com.hotels.tax.service.impl;

import com.hotels.tax.exception.InvalidInputParameterException;
import com.hotels.tax.exception.ProductNotFoundException;
import com.hotels.tax.model.IProduct;
import com.hotels.tax.service.IDataService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 212578960 on 8/12/2017.
 */
@Service
public class DataServiceImpl implements IDataService {

    Map<String, IProduct> dataSourceProduct = new HashMap<String, IProduct>();

    public IProduct getProductByCode(String code) throws ProductNotFoundException{
        IProduct product = dataSourceProduct.get(code);

        if(product == null){
            throw new ProductNotFoundException(String.format("Product not found for given code %s", code));
        }

        return dataSourceProduct.get(code);
    }

    public void addProduct(String code, IProduct product) {
        if(code == null || product == null) {
            throw new InvalidInputParameterException("Code or Product value missing in input parameters.");
        }

        dataSourceProduct.put(code, product);
    }

    public void removeProduct(String code) {
        dataSourceProduct.remove(code);
    }
}
