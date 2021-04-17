package com.fen.fou.danlianbiao;

public class HasHeadTailSingtonNode {
    Node head;
    Node tail;
    int nodeNum; //节点个数

public void add(Node e){
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
        nodeNum++;
    }else{           //如果新加的节点是一个链表而不是单节点
        Node tmp =  e;
        while (tmp != null){
            nodeNum++;
            if(tmp.next == null){
                tail = tmp;
                break;
            }
            tmp = tmp.next;
        }
    }
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

   //两个有序链表，合并 并且也生成一个有序链表
    public  HasHeadTailSingtonNode lspx(Node head1,Node head2){
        HasHeadTailSingtonNode hasHeadTailSingtonNode = new HasHeadTailSingtonNode();
            while (head1 != null && head2 != null){
                if(head1.value.compareTo(head2.value) < 0){
                    Node next = head1.next;
                    head1.next = null;
                    if(next == null){
                         head1.next = head2;
                     }
                    hasHeadTailSingtonNode.add(head1);
                    head1 = next;
                }else{
                    Node next = head2.next;
                    head2.next = null;
                    if(next == null){
                        head2.next = head1;
                    }
                    hasHeadTailSingtonNode.add(head2);
                    head2 = next;
                }
            }
        return hasHeadTailSingtonNode;
    }

    //两个链表value 相加
    public  void lsxj(HasHeadTailSingtonNode hasHeadSingtonNode1, HasHeadTailSingtonNode hasHeadSingtonNode2){
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
        HasHeadTailSingtonNode hasHeadTailSingtonNode = new HasHeadTailSingtonNode();

        Node head1 = hasHeadSingtonNode1.head;
        Node head2 = hasHeadSingtonNode2.head;
        while (head1 != null && head2 != null){

            hasHeadTailSingtonNode.add(new Node(String.valueOf(Integer.parseInt(head1.value) +Integer.parseInt(head2.value))));

            head1 = head1.next;
            head2 = head2.next;
        }
        this.head = hasHeadTailSingtonNode.head;
    }

}
