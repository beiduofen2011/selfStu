package com.example.stu.singleLinkedList;

import lombok.Data;

@Data
public class Node<T>{
    private T t;
    private Node next;
    public Node(T t,Node next){
        this.t = t;
        this.next = next;
    }
    public Node(T t){
        this(t,null);
    }
}
