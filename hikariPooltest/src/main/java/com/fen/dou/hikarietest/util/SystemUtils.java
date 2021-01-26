package com.fen.dou.hikarietest.util;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * @Author: hejis
 * @Description:
 * @Date: Create in 10:09 2019/5/21
 * @Modified By:
 */
@Slf4j
public class SystemUtils {

    public static final String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    /**
     * 第一种方式：纳秒 通过nanoTime()方法获得
     * 通过System类的nanoTime()方法产生，理论上存在重复的可能，实际不会重复
     */
    public static String uniqueCodeNanoTime() {
        long n=System.nanoTime();
        return String.valueOf(n);
    }

    /**
     * 第二种方式：获得一个UUID
     * @return String UUID
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }

    /**
     * 生成8位短Uuid字符串
     * @return
     */
    public static String generateShortUuid(String uuid) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            builder.append(chars[x % 0x3E]);
        }
        return builder.toString();
    }
}
