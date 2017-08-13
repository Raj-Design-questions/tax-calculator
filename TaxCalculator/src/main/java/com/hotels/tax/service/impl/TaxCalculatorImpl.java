package com.hotels.tax.service.impl;

import com.hotels.tax.builder.ReceiptBuilder;
import com.hotels.tax.model.IProduct;
import com.hotels.tax.service.IDataService;
import com.hotels.tax.service.ITaxCalculator;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 212578960 on 8/13/2017.
 */
@Service
public class TaxCalculatorImpl implements ITaxCalculator {

    @Inject IDataService dataService;

    public String getTaxCalculatedReceipt(Map<String, Integer> products) {
        Map<IProduct, Integer> productQuantityMap = new LinkedHashMap<IProduct, Integer>();
        if(products != null){
            for (Map.Entry<String, Integer> entry : products.entrySet()){
                String code = entry.getKey();
                Integer quantity = entry.getValue();
                try{
                    IProduct product = dataService.getProductByCode(code);
                    productQuantityMap.put(product, quantity);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        StringBuilder printReceipt = new StringBuilder("Nothing to print!!!");
        if(! productQuantityMap.isEmpty()){
            printReceipt = ReceiptBuilder.createReceiptBuilder(productQuantityMap).withItemTaxAndTotal().build();
        }
        printReceipt.append("\n###############################################################################");
        return printReceipt.toString();
    }
}
