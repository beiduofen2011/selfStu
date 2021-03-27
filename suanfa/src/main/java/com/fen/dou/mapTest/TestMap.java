package com.fen.dou.mapTest;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {


          System.out.println(1 << 30);
          System.out.println(1 << 5);
          System.out.println(Integer.MAX_VALUE);
//        Map hashMap = new HashMap<>();
//        hashMap.
//        for(int i = 0;i< 17;i++){
//            hashMap.put(i,i);
//        }

//        MyHashMap myHashMap = new MyHashMap();
//        myHashMap.put(1,2);
//        System.out.println(myHashMap.get(1));
    }
}
class MyHashMap {

    Node[] array;
    int size;
    int length = 1<<15;

    public MyHashMap() {
        array = new Node[1<<15];//make sure size is powers of 2
        size =0;
    }

    public void put(int key, int value) {
       if(array.length > length*0.75){
           Node[] nodes = new Node[array.length*2];
           nodes = Arrays.copyOf(array,array.length);
           array = nodes;
       }
        if(array[key] != null) {
            if(array[key].getValue() == value){
               return;
            }else{
                array[key].setValue(value);
            }
        }else{
            array[key] = new Node(key,value);
        }
    }

    public int get(int key) {
        if(array[key] == null){
            return -1;
        }else{
            return array[key].getValue();
        }
    }

    public void remove(int key) {
        if(array[key] == null){
            return ;
        }else{
             array[key] = null;
        }
    }

    class Node{

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        int key;
        int value;

        Node next;

        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
        public Node(){
        }
    }
}