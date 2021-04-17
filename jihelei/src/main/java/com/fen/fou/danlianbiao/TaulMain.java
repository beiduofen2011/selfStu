package com.fen.fou.danlianbiao;

public class TaulMain {
    public static void main(String[] args) {
        Node node1 = new Node("a");
        Node node2 = new Node("b");
        Node node3 = new Node("c");
        Node node4 = new Node("d");
        Node node5 = new Node("e");

        HasHeadTailSingtonNode hasHeadSingtonNode = new HasHeadTailSingtonNode();
        hasHeadSingtonNode.add(node1);
        hasHeadSingtonNode.add(node2);
        hasHeadSingtonNode.add(node3);
        hasHeadSingtonNode.add(node4);
        hasHeadSingtonNode.add(node5);
        Node tmp = node1;
        while (tmp != null){
            System.out.print(tmp.value);
            tmp = tmp.next;
        }

        hasHeadSingtonNode.fanzhun(hasHeadSingtonNode.head);


        Node tmp2 = hasHeadSingtonNode.head;
        System.out.print("\n");
        while (tmp2 != null){
            System.out.print(tmp2.value);
            tmp2 = tmp2.next;
        }
        HasHeadTailSingtonNode hasHeadSingtonNode1 = new HasHeadTailSingtonNode();
        hasHeadSingtonNode1.add(new Node("a"));
        hasHeadSingtonNode1.add(new Node("c"));
        hasHeadSingtonNode1.add(new Node("e"));
        hasHeadSingtonNode1.add(new Node("g"));
        hasHeadSingtonNode1.add(new Node("i"));
        hasHeadSingtonNode1.add(new Node("x"));
        hasHeadSingtonNode1.add(new Node("y"));

        HasHeadTailSingtonNode hasHeadSingtonNode2 = new HasHeadTailSingtonNode();
        hasHeadSingtonNode2.add(new Node("b"));
        hasHeadSingtonNode2.add(new Node("d"));
        hasHeadSingtonNode2.add(new Node("f"));
        hasHeadSingtonNode2.add(new Node("h"));
        hasHeadSingtonNode2.add(new Node("j"));
        hasHeadSingtonNode2.add(new Node("u"));
        hasHeadSingtonNode2.add(new Node("v"));
        hasHeadSingtonNode2.add(new Node("w"));

        HasHeadTailSingtonNode hasHeadSingtonNode3 = new HasHeadTailSingtonNode();
        hasHeadSingtonNode3 = hasHeadSingtonNode3.lspx(hasHeadSingtonNode1.head,hasHeadSingtonNode2.head);
        System.out.println(hasHeadSingtonNode3.nodeNum);

        Node aaaa = hasHeadSingtonNode3.head;
        System.out.print("\n");
        while (aaaa != null){
            System.out.print(aaaa.value);
            aaaa = aaaa.next;
        }

        HasHeadTailSingtonNode hasHeadSingtonNode4 = new HasHeadTailSingtonNode();
        hasHeadSingtonNode4.add(new Node("1"));
        hasHeadSingtonNode4.add(new Node("2"));


        HasHeadTailSingtonNode hasHeadSingtonNode5 = new HasHeadTailSingtonNode();
        hasHeadSingtonNode5.add(new Node("3"));
        hasHeadSingtonNode5.add(new Node("4"));

        HasHeadTailSingtonNode hasHeadSingtonNode6 = new HasHeadTailSingtonNode();
        hasHeadSingtonNode6.lsxj(hasHeadSingtonNode4,hasHeadSingtonNode5);


        Node aaaaa = hasHeadSingtonNode6.head;
        System.out.print("\n");
        while (aaaaa != null){
            System.out.print(aaaaa.value);
            aaaaa = aaaaa.next;
        }
    }
}
