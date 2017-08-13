package com.hotels.tax.support;

import com.hotels.tax.service.IDataService;
import com.hotels.tax.service.impl.DataServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import javax.inject.Inject;

/**
 * Created by 212578960 on 8/13/2017.
 */
@Configuration
@ComponentScan(
        value = {
                "com.hotels.tax"}
)
public class Application {
    @Inject IDataService dataService;

    public static void main(String[] args){
        System.out.println("Started");
    }
}
