package com.fen.dou.sjms.factory;

public class SimpleFactory {
    public static void main(String[] args) {
        Product product = SimpleFactory.createProdcut("1");
        product.method1();
    }
    public static Product createProdcut(String type) {
        if (type.equals( "0" )) {
            return new ProductA();
        } else if (type.equals( "1" )) {
            return new ProductA1();
        } else {
            return null;
        }
    }
}