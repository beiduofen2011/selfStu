package com.fen.dou.mapTest.zifuchuan;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class Str {
    public static void main(String[] args) throws ScriptException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.replaceAll("\\{","(");
        s = s.replaceAll("\\}",")");
        s = s.replaceAll("\\[","(");
        s = s.replaceAll("\\]",")");
        ScriptEngineManager em = new ScriptEngineManager();
        ScriptEngine javaScript = em.getEngineByName("JavaScript");
        System.out.println(javaScript.eval(s));
    }
}
