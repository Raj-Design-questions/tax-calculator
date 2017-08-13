package com.hotels.tax.service;

import com.hotels.tax.model.IProduct;

import java.util.List;
import java.util.Map;

/**
 * Created by 212578960 on 8/6/2017.
 */
public interface IReceipt {
    StringBuilder print(Map<IProduct, Integer> products);
}
