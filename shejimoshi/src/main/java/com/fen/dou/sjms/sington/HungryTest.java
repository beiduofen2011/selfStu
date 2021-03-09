package com.fen.dou.sjms.sington;

import java.io.*;

public class HungryTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HungrySington hungrySington1 = HungrySington.getInstance();
        HungrySington hungrySington2 = HungrySington.getInstance();
        System.out.println(hungrySington1 == hungrySington2);


        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("sssssss"));
        objectOutputStream.writeObject(hungrySington1);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("sssssss"));
        HungrySington hungrySington3 = (HungrySington)objectInputStream.readObject();
        System.out.println( hungrySington2 == hungrySington3);

    }
}
class HungrySington implements Serializable {
    private static HungrySington hungrySington = new HungrySington();
    private HungrySington(){
        if(hungrySington != null){
            throw new RuntimeException("已经存在对象");
        }
    }
    public static HungrySington getInstance(){
        return hungrySington;
    }

    Object readResolve() throws ObjectStreamException{
        return hungrySington;
    }
}