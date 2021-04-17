package yc.fen.dou.nettyStu.selfNetty;

import java.util.concurrent.atomic.AtomicLong;

public class Lunxunsf {
    public static void main(String[] args) throws InterruptedException {
        String[] a = {"a","b","c"};
        Lunxun lunxun = new Lunxun(a);
        for(;;){
            Thread.sleep(1000);
            System.out.print(lunxun.next());
        }
    }
}
class Lunxun{
    Lunxun(String[] stra){
        this.stra = stra;
    }
    private final AtomicLong idx = new AtomicLong();
    private  String[] stra;

    public String next() {
        return stra[(int) Math.abs(idx.getAndIncrement() % stra.length)];
    }
}