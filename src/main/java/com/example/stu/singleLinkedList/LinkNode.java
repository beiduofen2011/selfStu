package com.example.stu.singleLinkedList;

import lombok.Data;

@Data
public class LinkNode<T> {

    private Node<T> head;    		//头结点
    private int size;			//链表元素个数
    //构造函数
    public LinkNode(){
        this.head = null;
        this.size = 0;
    }
}
