package com.example.stu.sjjg;

import java.util.Stack;

public class MyStack<E> {
    private Object[] data = null;
    private int maxSize = 0;
    private int top = -1;
    MyStack(){
        this(10);
    }
    MyStack(int initSize){
        if(initSize >= 0){
            this.maxSize = initSize;
            data = new Object[initSize];
            top = -1;
        }else {
            throw new RuntimeException("初始化大小不能小于0："+initSize);
        }
    }

}
