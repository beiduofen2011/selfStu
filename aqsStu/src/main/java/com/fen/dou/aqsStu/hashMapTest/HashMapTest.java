package com.fen.dou.aqsStu.hashMapTest;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap map = new HashMap<String,String>();
        int  hashcode1 = 97 ^ (97 >>> 16);
        System.out.println(hashcode1 & 16);
        System.out.println(hashcode1 & 15);
        String key = "fbf30d3b-88a9-4f5d-b663-f78f28d24dec";
        map.put("e83f0a1a-98a2-426f-897c-d2302ac47a42","1");
        map.put("903b3251-d147-4299-9a98-a3c8a2c5d4b4","2");
        map.put("5bddd66a-0796-47a9-a1e0-7b9c124edd41","3");
        map.put("15ee2693-9f13-453b-adcd-cdfe9ed14ecf","4");
        map.put("413785fd-636d-4814-be60-d8c26472575a","5");
        map.put("2bed2581-8ee6-49d5-b8cb-bfaf222b606e","6");
        map.put("1e96f7ee-a940-40b6-a3d8-24ea2fca8a14","7");
        map.put("adf75204-d230-4cd1-8aee-26d015653a02","8");
        map.put("1ca012d9-54cb-497d-bcca-591540222e9d","9");
        map.put("fbf30d3b-88a9-4f5d-b663-f78f28d24dec","10");
        map.put("0cfcd176-eae8-4090-ae26-5ad70325f64f","11");
        map.put("dadd3a41-ef4f-4466-a9b8-b0f307997ad7","12");
        map.put("4b3d4f27-5a6e-461d-8487-115d3d3986f4","13");
        map.put("a493deb7-c550-4877-90ee-7c10fccd3d61","14");
        map.put("8a4a2f4f-3288-4955-91c8-2dbffea8bb9c","15");
        map.put("be606a58-d13d-412a-a282-9245418fc8bc","16");
        map.put("c7ba2b07-3c57-4f7f-92fc-ba1230052640","17");
        map.put("c4d25feb-bead-4a83-9a49-cd60ee4a8839","18");
        map.put("7d10b612-78e5-45c9-8ada-9dd10b711a9b","19");
        map.put("8d9aaf89-8c48-49f0-8acc-b84e6d294a2c","12");
//        System.out.println(key.hashCode() +   "----------"  +key.hashCode() >>> 16  );
        System.out.println(97 >>> 16);
        map.forEach((k,v)->{
//            int  hashcode = k.hashCode() ^ (k.hashCode() >>> 16);
//            int index1 = (16 - 1) & hashcode;
            int  hashcode = k.hashCode() ;
            int index1 = (16 - 1) & hashcode;
            System.out.println(index1);

        });
//        int  hashcode = key.hashCode() ^ (key.hashCode() >>> 16);
//
//        int index1 = (16 - 1) & hashcode;
//        System.out.println(1<<4);
//        System.out.println(1<<4 - 1);
//        System.out.println(hashcode);
//
//        System.out.println(index1);
    }
}
