package model;

import java.util.Objects;

public class Product {

    private static String productName;
    private static String serialNumber;

    public Product(String productName)
    {
        this.productName = productName;
    }
    public Product(String productName, String serialNumber)
    {
        this.productName = productName;
        this.serialNumber = serialNumber;
    }

    public static String getProductName() { return productName; }
    public static String getSerialNumber() { return serialNumber; }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                "serialNumber='" + serialNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName)
                && Objects.equals(serialNumber, product.serialNumber);
    }


    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }
}
