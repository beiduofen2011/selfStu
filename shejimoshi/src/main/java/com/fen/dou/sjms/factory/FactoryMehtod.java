package com.fen.dou.sjms.factory;

public class FactoryMehtod {
    public static void main(String[] args) {
        Application application =  new ConcreteProductA();
        application.getObject().method1();

        Application application1 =  new ConcreteProductA1();
        application.getObject().method1();
    }
}

interface Product {
    public void method1();
}
// 具体实现
class ProductA implements Product {
        public void method1() {
            System.out.println( "ProductA.methodA executed. " );
        }
}
// 工厂方法具体实现类
class ConcreteProductA extends Application {
    @Override
    Product createProduct() {
        return new ProductA();
    }
}

class ProductA1 implements Product {
    public void method1() {
        System.out.println( "ProductA1.methodA1 executed. " );
    }
}
class ConcreteProductA1 extends Application {
    @Override
    Product createProduct() {
        return new ProductA1();
    }
}

abstract class Application {
    abstract Product createProduct();
    Product getObject() {
        Product product=createProduct();
        return product;
    }
}



