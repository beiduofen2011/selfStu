package com.fen.fou;


import lombok.Data;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws Exception {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        Class<Person> personClass = Person.class;
        Field name = personClass.getField("NAME");
        Field age = personClass.getField("age");
        try {
            System.out.println("objectFieldOffset name -->" + unsafe.objectFieldOffset(name));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("objectFieldOffset age -->" + unsafe.objectFieldOffset(age));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("staticFieldOffset name -->" + unsafe.staticFieldOffset(name));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("staticFieldOffset age -->" + unsafe.staticFieldOffset(age));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

@Data
class Person {

    public static String NAME = "doge";
    public String age;
}