package com.fen.dou.queueStu;

import java.util.*;
import java.util.concurrent.*;

public class QueueStu {
    public static void main(String[] args) throws InterruptedException {

        SynchronousQueue synchronousQueue1 = new SynchronousQueue(false);
        new Thread(()->{
            try {
                System.out.println(synchronousQueue1.take());
                System.out.println(synchronousQueue1.take());
                System.out.println(synchronousQueue1.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                synchronousQueue1.put(1);
                synchronousQueue1.put(3);
                synchronousQueue1.put(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(20);
        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("b");
        arrayBlockingQueue.put("c");
        arrayBlockingQueue.put("d");
        System.out.println(arrayBlockingQueue.take());
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(20);
        linkedBlockingQueue.put("a");
        linkedBlockingQueue.put("b");
        linkedBlockingQueue.put("c");
        linkedBlockingQueue.put("d");


        PriorityQueue priorityQueue = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return Integer.parseInt(String.valueOf(o1)) - Integer.parseInt(String.valueOf(o2));
            }
        });
        priorityQueue.add("1000");
        priorityQueue.add("20");
        priorityQueue.add("1");
        priorityQueue.add("19");
        Iterator iterator =  priorityQueue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
