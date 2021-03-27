package com.fen.dou.aqsStu.hashMapTest;

import sun.misc.Unsafe;

public class GetUnsafe {
    public Unsafe getUnsafe(){
        Unsafe unsafe = Unsafe.getUnsafe();
        return unsafe;
    }
}
