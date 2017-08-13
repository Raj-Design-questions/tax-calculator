package com.hotels.tax.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by 212578960 on 8/13/2017.
 */
public class CalculatorUtil {
    public static Float roundToMultipleOfFive(Float value) {
        BigDecimal a = new BigDecimal(value);
        BigDecimal roundOff1 = a.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal roundOff2 = a.setScale(1, BigDecimal.ROUND_HALF_EVEN);
        Float result;
        if(roundOff2.floatValue() < roundOff1.floatValue()){
            result = roundOff2.floatValue() + 0.05f;
        }else {
            result = roundOff2.floatValue();
        }
        return result;
    }

    public static Float roundOf(Float value) {
        return Math.round(value * 100)/100.0f;
    }

    public static String format(Float value){
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(value);
    }
}
