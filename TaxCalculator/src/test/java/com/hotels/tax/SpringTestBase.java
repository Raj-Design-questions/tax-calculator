package com.hotels.tax;

import com.hotels.tax.model.IProduct;
import com.hotels.tax.model.impl.CompactDisc;
import com.hotels.tax.model.impl.ComputerAccessory;
import com.hotels.tax.model.impl.GeneralProduct;
import com.hotels.tax.model.impl.MedicalProduct;
import com.hotels.tax.service.IDataService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by 212578960 on 8/13/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
public abstract class SpringTestBase extends TestBase {
    @Inject IDataService dataService;

    public static String BOOK_BAR_CODE      = "BARCODE1231";
    public static String MUSIC_CD_TYPE1_BAR_CODE   = "BARCODE1232";
    public static String CHOCOLATE_SNACK_BAR_CODE = "BARCODE1233";
    public static String WINE_BOTTLE_BAR_CODE = "BARCODE1234";
    public static String BOX_OF_HEADACHE_PILLS_BAR_CODE = "BARCODE1235";
    public static String BOX_OF_PINS_BAR_CODE = "BARCODE1236";
    public static String MUSIC_CD_TYPE2_BAR_CODE   = "BARCODE1237";

    @Before
    public void loadProducts(){
        IProduct book = new GeneralProduct("book", BOOK_BAR_CODE, 29.49f);
        dataService.addProduct(BOOK_BAR_CODE, book);

        IProduct musicCDType1 = new CompactDisc("music CD", MUSIC_CD_TYPE1_BAR_CODE, 15.99f);
        dataService.addProduct(MUSIC_CD_TYPE1_BAR_CODE, musicCDType1);

        IProduct chocolateSnack = new GeneralProduct("chocolate snack", CHOCOLATE_SNACK_BAR_CODE, 0.75f);
        dataService.addProduct(CHOCOLATE_SNACK_BAR_CODE, chocolateSnack);

        IProduct wineBottle = new GeneralProduct("bottle of wine", WINE_BOTTLE_BAR_CODE, 20.99f);
        dataService.addProduct(WINE_BOTTLE_BAR_CODE, wineBottle);

        IProduct boxOfHeadachePills = new MedicalProduct("box of headache pills", BOX_OF_HEADACHE_PILLS_BAR_CODE, 4.15f);
        dataService.addProduct(BOX_OF_HEADACHE_PILLS_BAR_CODE, boxOfHeadachePills);

        IProduct boxOfPins = new GeneralProduct("box of pins", BOX_OF_PINS_BAR_CODE, 11.25f);
        dataService.addProduct(BOX_OF_PINS_BAR_CODE, boxOfPins);

        IProduct musicCDType2 = new CompactDisc("music CD", MUSIC_CD_TYPE2_BAR_CODE, 14.99f);
        dataService.addProduct(MUSIC_CD_TYPE2_BAR_CODE, musicCDType2);
    }
}
