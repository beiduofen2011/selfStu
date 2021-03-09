package com.fen.dou.sjms.sington;

import java.io.*;

public class EunmTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        EunmSington eunmSington1 = EunmSington.SINGTON;
        EunmSington eunmSington2 = EunmSington.SINGTON;
        System.out.println(eunmSington1 == eunmSington2);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("eunmSington"));
        objectOutputStream.writeObject(eunmSington2);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("eunmSington"));
        EunmSington eunmSington3 = (EunmSington)objectInputStream.readObject();
        System.out.println( eunmSington2 == eunmSington3);
        eunmSington3.say();

    }
}
enum EunmSington{
    SINGTON;

    public void say(){
        System.out.println("-----------------");
    }
}