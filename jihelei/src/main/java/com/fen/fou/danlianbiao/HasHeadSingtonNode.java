package com.fen.fou.danlianbiao;

import com.fen.fou.CasTestObjecy;
import org.springframework.objenesis.instantiator.util.UnsafeUtils;
import sun.misc.Unsafe;

public class HasHeadSingtonNode {
    Node head;
    Node tail;
    int nodeNum;

//    private static  Long NODENUM = 0l;
//    private static   Unsafe u = null;
//    static {
//         u = UnsafeUtils.getUnsafe();
//        try {
//            long NODENUM = u.objectFieldOffset(CasTestObjecy.class.getDeclaredField("nodeNum"));
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//    }
//    public void add(Node e){
//    //    while (u.compareAndSwapInt(this,NODENUM ,nodeNum,nodeNum+1));
//        if(head == null){
//            head = e;
//        }else {
//            Node temp = head;
//            while (temp != null){
//                if(temp.next == null){
//                    temp.next = e;
//                    break;
//                }else{
//                    temp = temp.next;
//                }
//            }
//        }
//        nodeNum++;
//    }
    public void add(Node e){
        //    while (u.compareAndSwapInt(this,NODENUM ,nodeNum,nodeNum+1));
        if(head == null){
            head = e;
        }else {
            Node temp = tail;
            if(temp.next == null){
                temp.next = e;
            }
        }
        if(e.next == null){//如果新加的节点只是一个单节点
            tail = e;
        }else{           //如果新加的节点是一个链表而不是单节点
            Node tmp =  e;
           while (tmp != null){
               if(tmp.next == null){
                   tail = tmp;
                   break;
               }
               tmp = tmp.next;
           }
        }
        nodeNum++;
    }
    //反转链表
    public  void fanzhun(Node head){
        Node rescNode = null;
        Node node = head;
        while (node != null){
            Node next = node.next;
            node.next = null;
            if(rescNode != null){
                node.next = rescNode ;
            }
            rescNode = node;
            node = next;
        }
         this.head = rescNode;
    }


    public  void lspx(Node head1,Node head2){
        Node node = null;
            while (head1 != null && head2 != null){
                if(head1.value.compareTo(head2.value) < 0){
                    Node next = head1.next;
                    head1.next = null;
                   if(node == null){
                       node = head1;
                   }else {
                       Node tmp = node;
                       while (tmp != null){
                           if(tmp.next == null){
                               if(next == null){
                                   head1.next = head2;
                               }
                               tmp.next = head1;
                               break;
                           }else{
                               tmp = tmp.next;
                           }
                       }
                   }
                    head1 = next;
                }else{
                    Node next = head2.next;
                    head2.next = null;
                    if(node == null){
                        node = head2;
                    }else {
                            Node tmp = node;
                            while (tmp != null){
                                if(tmp.next == null){
                                    if(next == null){
                                        head2.next = head1;
                                    }
                                    tmp.next = head2;
                                    break;
                                }else{
                                    tmp = tmp.next;
                                }
                            }
                    }
                    head2 = next;
                }
            }
        this.head = node;
    }


    public  void lsxj(HasHeadSingtonNode hasHeadSingtonNode1,HasHeadSingtonNode hasHeadSingtonNode2){
        if(hasHeadSingtonNode1.nodeNum > hasHeadSingtonNode2.nodeNum){
            int a = hasHeadSingtonNode1.nodeNum - hasHeadSingtonNode2.nodeNum;
            for(int i=0 ; i <a ; i++){
                Node tmp = new Node("0").next ;
                tmp.next = hasHeadSingtonNode2.head;
                hasHeadSingtonNode2.head = tmp;
            }
        }else{
            int a = hasHeadSingtonNode2.nodeNum - hasHeadSingtonNode1.nodeNum;
            for(int i=0 ; i <a ; i++){
                Node tmp = new Node("0").next ;
                tmp.next = hasHeadSingtonNode1.head;
                hasHeadSingtonNode1.head = tmp;
            }
        }
        Node node = null;
        Node head1 = hasHeadSingtonNode1.head;
        Node head2 = hasHeadSingtonNode2.head;
        while (head1 != null && head2 != null){

            if(node == null){
                node = new Node(String.valueOf(Integer.parseInt(head1.value) +Integer.parseInt(head2.value)));
            }else{
                Node tmp = node;
                while (tmp != null){
                    if(tmp.next == null){
                        tmp.next = new Node(String.valueOf(Integer.parseInt(head1.value) +Integer.parseInt(head2.value)));
                        break;
                    }
                    tmp = tmp.next;
                }
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        this.head = node;
    }

}
