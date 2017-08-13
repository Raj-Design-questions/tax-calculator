package com.hotels.tax.model.impl;

import com.hotels.tax.builder.ReceiptBuilder;
import com.hotels.tax.exception.ProductNotFoundException;
import com.hotels.tax.model.IProduct;
import com.hotels.tax.service.IDataService;
import com.hotels.tax.support.SpringTestBase;
import org.junit.Test;

import javax.inject.Inject;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by 212578960 on 8/13/2017.
 */
public class TaxCalculatorImplTest extends SpringTestBase{

    @Inject IDataService dataService;

    @Test
    public void texForGeneralProduct_withReceiptBuilder_succeed() throws ProductNotFoundException{
        Map<IProduct, Integer> products = new LinkedHashMap<IProduct, Integer>();
        products.put(dataService.getProductByCode(BOOK_BAR_CODE), 1);
        StringBuilder text = ReceiptBuilder.createReceiptBuilder(products).withItems().withSalesTax().withTotalAmount().build();
        assertNotNull(text);
        assertTrue(text.toString().contains("1 book 34.69"));
        assertTrue(text.toString().contains("Sales Tax : 5.20"));
        assertTrue(text.toString().contains("Total : 34.69"));
    }

    @Test
    public void texForMedicalProduct_withReceiptBuilder_succeed() throws ProductNotFoundException{
        Map<IProduct, Integer> products = new LinkedHashMap<IProduct, Integer>();
        products.put(dataService.getProductByCode(BOX_OF_HEADACHE_PILLS_BAR_CODE), 1);
        StringBuilder text = ReceiptBuilder.createReceiptBuilder(products).withItems().withSalesTax().withTotalAmount().build();
        assertNotNull(text);
        assertTrue(text.toString().contains("1 box of headache pills 4.15"));
        assertTrue(text.toString().contains("Sales Tax : 0.00"));
        assertTrue(text.toString().contains("Total : 4.15"));
    }

    @Test
    public void texForCDProduct_withReceiptBuilder_succeed() throws ProductNotFoundException{
        Map<IProduct, Integer> products = new LinkedHashMap<IProduct, Integer>();
        products.put(dataService.getProductByCode(MUSIC_CD_TYPE1_BAR_CODE), 1);
        StringBuilder text = ReceiptBuilder.createReceiptBuilder(products).withItems().withSalesTax().withTotalAmount().build();
        assertNotNull(text);
        assertTrue(text.toString().contains("1 music CD 20.04"));
        assertTrue(text.toString().contains("Sales Tax : 4.05"));
        assertTrue(text.toString().contains("Total : 20.04"));
    }
}
