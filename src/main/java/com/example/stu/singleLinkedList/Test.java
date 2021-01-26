package com.example.stu.singleLinkedList;

public class Test {
    public static void main(String[] args) {
       Node node0 = new Node("a");
       Node node1 = new Node("b");
       Node node2 = new Node("c");
       Node node3 = new Node("d");
       Node node4 = new Node("e");
       Node node5 = new Node("f");

       node0.setNext(node1);
       node1.setNext(node2);
       node2.setNext(node3);
       node3.setNext(node4);
       node4.setNext(node5);

       LinkNode linkNode  = new LinkNode();
       int len = 0;
       Node head = node0;
       linkNode.setHead(head);
       while (head.getNext() != null){
           len++;
           head  = head.getNext();
       }
       linkNode.setSize(len);
    }
}
