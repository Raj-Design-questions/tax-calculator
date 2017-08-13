package com.hotels.tax;

import com.hotels.tax.service.ITaxCalculator;
import org.junit.Test;

import javax.inject.Inject;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 212578960 on 8/13/2017.
 */
public class TaxCalculatorRunner extends SpringTestBase{

    @Inject ITaxCalculator taxCalculator;

    @Test
    public void testFirstReceipt(){
        Map<String, Integer> products = new LinkedHashMap<String, Integer>();
        products.put(BOOK_BAR_CODE, 1);
        products.put(MUSIC_CD_TYPE1_BAR_CODE, 1);
        products.put(CHOCOLATE_SNACK_BAR_CODE, 1);
        String receipt = taxCalculator.getTaxCalculatedReceipt(products);
        System.out.println(receipt);
    }

    @Test
    public void testSecondReceipt(){
        Map<String, Integer> products = new LinkedHashMap<String, Integer>();
        products.put(WINE_BOTTLE_BAR_CODE, 1);
        products.put(BOX_OF_HEADACHE_PILLS_BAR_CODE, 1);
        products.put(BOX_OF_PINS_BAR_CODE, 1);
        products.put(MUSIC_CD_TYPE2_BAR_CODE, 1);
        String receipt = taxCalculator.getTaxCalculatedReceipt(products);
        System.out.println(receipt);
    }
}
