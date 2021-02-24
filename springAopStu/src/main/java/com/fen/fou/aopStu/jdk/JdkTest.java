package com.fen.fou.aopStu.jdk;

import java.lang.reflect.Proxy;

public class JdkTest {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        TestInvocationHandler testInvocationHandler = new TestInvocationHandler(new SayImpl());
        Say say = (Say) Proxy.newProxyInstance(SayImpl.class.getClassLoader(), SayImpl.class.getInterfaces(), testInvocationHandler );
        say.sayHello("yangcai");
    }
}
