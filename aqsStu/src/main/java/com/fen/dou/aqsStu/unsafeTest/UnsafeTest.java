package com.fen.dou.aqsStu.unsafeTest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        //因为 Unsafe 的 theUnsafe 字段是private 的，所以这里需要设置成可访问的
        field.setAccessible(true);
        //Unsafe 的这个属性 theUnsafe 是静态的所以这里的get参数就是null
        Unsafe unsafe = (Unsafe)field.get(null);
        String[] a = new String[2];
        unsafe.putObjectVolatile(a, 1, "a");
        String aa = (String) unsafe.getObjectVolatile(a, 1);
        System.out.println(aa);

        int  arrayBaseOffsetint = unsafe.arrayBaseOffset(int[].class);
        int arrayIndexScaleint = unsafe.arrayIndexScale(int[].class);
        System.out.println(arrayBaseOffsetint);
        System.out.println(arrayIndexScaleint);
        int  arrayBaseOffsetstring = unsafe.arrayBaseOffset(String[].class);
        int arrayIndexScalestring = unsafe.arrayIndexScale(String[].class);
        System.out.println(arrayBaseOffsetstring);
        System.out.println(arrayIndexScalestring);


        System.out.println(Integer.numberOfLeadingZeros(-4));

      //  Integer.toBinaryString()

    }
}
