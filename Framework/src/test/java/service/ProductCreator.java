package service;

import model.Product;

public class ProductCreator {

    public static final String TESTED_PRODUCT_NAME = "testdata.product.productName";
    public static final String TESTED_PRODUCT_SERIALNUMBER = "testdata.product.serialNumber";

    public static Product EnterProductName(){
        return new Product(TestDataReader.getTestData(TESTED_PRODUCT_NAME));
    }

    public static Product EnterProductNameAndSerialNumber(){
        return new Product(TestDataReader.getTestData(TESTED_PRODUCT_NAME),
                (TestDataReader.getTestData(TESTED_PRODUCT_SERIALNUMBER)));
    }
}
