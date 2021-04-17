package yc.fen.dou.nettyStu.selfNetty;

import java.io.IOException;
import java.nio.channels.Selector;

public class Test {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
//        new Thread(()->{
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            selector.wakeup();
//        }).start();
//        new Thread(()->{
//            try {
//                Thread.sleep(1000);
//                new Test1(selector).selector();
//            } catch (InterruptedException | IOException e) {
//                e.printStackTrace();
//            }
//            //  selector.wakeup();
//        }).start();
//        new Thread(()->{
//            try {
//                Thread.sleep(1000);
//                new Test1(selector).selector();
//            } catch (InterruptedException | IOException e) {
//                e.printStackTrace();
//            }
//          //  selector.wakeup();
//        }).start();
        new Thread(()->{
            try {
             //   Thread.sleep(1000);
                new Test2(selector).selector();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //  selector.wakeup();
        }).start();
        new Thread(()->{
            try {
                Thread.sleep(5000);
                new Test2(selector).selector();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            //  selector.wakeup();
        }).start();
    }
}
class Test1{
    Selector selector = null;
    Test1(Selector selector){
        this.selector = selector;
    }

    public  void selector() throws IOException {
  //      while (true){
            selector.select();
            System.out.println("--------");
  //      }
    }
}
class Test2{
    Selector selector = null;
    Test2(Selector selector){
        this.selector = selector;
    }

    public  void selector() throws IOException {
        while (true){
        selector.select(3000);
        System.out.println("-----1---");
        }
    }
}