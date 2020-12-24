package service;

import model.Product;

public class ProductCreator {

    public static final String TESTED_PRODUCT_NAME = "testdata.product.productName";

    public static Product EnterProductName(){
        return new Product(TestDataReader.getTestData(TESTED_PRODUCT_NAME));
    }
}
