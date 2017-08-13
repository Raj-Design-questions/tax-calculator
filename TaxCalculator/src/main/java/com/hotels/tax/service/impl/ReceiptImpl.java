package com.hotels.tax.service.impl;

import com.hotels.tax.model.IProduct;
import com.hotels.tax.service.IReceipt;
import com.hotels.tax.util.CalculatorUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by 212578960 on 8/12/2017.
 */
@Service
public class ReceiptImpl implements IReceipt {

    public StringBuilder print(Map<IProduct, Integer> products) {
        StringBuilder str = new StringBuilder();
        Float totalSalesTax = 0f;
        Float total = 0f;
        for(Map.Entry<IProduct, Integer> entry : products.entrySet()){
            IProduct product = entry.getKey();
            Integer quantity = entry.getValue();
            if(quantity != null && quantity > 0){
                Float taxedPrice = product.getTaxedPrice();
                Float price = product.getPrice();
                Float totalPrice = (price + taxedPrice) * quantity;
                totalSalesTax += taxedPrice * quantity;
                total += totalPrice;
                str.append(quantity).append(" ").append(product.getName()).append(" ").append(CalculatorUtil.format(totalPrice));
                str.append("\n");
            }

        }

        str.append("Sales Tax : ").append(CalculatorUtil.format(totalSalesTax)).append("\n");
        str.append("Total : ").append(CalculatorUtil.format(total));
        return str;
    }
}
