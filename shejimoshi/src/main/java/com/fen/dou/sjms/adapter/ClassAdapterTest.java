package com.fen.dou.sjms.adapter;

public class ClassAdapterTest {
    public static void main(String[] args) {
        Adpater adpater=new Adpater();
        adpater.output5v();
    }
}
// Class Adapter
class Adpater extends Adaptee implements Target{
    @Override
    public int output5v() {
        int i= output220v();
        // ......
        System.out.println(String.format( "原始电压： %d v ‐ > 输出电压： %d v ",i,5 ));
        return 5;
    }
}
