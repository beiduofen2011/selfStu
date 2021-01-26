package com.example.stu;

import org.springframework.scheduling.support.CronSequenceGenerator;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

    public  static  FileOutputStream fos = null;

    public static void main(String[] args) throws Exception {

        File file = new File("C:\\Users\\70765\\Desktop\\ssssss\\shuj.txt");

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            int i = 0;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                String mystr = br.readLine();
                System.out.println("mystr"+mystr);
                if(mystr != null){
                    String[]  str = mystr.split("\\|");
                    String taskName  = str[0];
                    String startTime = str[1];
                    String endTime   = str[2];
                    String cron    = str[3];
                    String processDefinitionId = str[4];
                    System.out.println("taskName"+taskName);
                    System.out.println("startTime"+startTime);
                    System.out.println("endTime"+endTime);
                    System.out.println("cron"+cron);
                    System.out.println("processDefinitionId"+processDefinitionId);

                    System.out.println("-------i----------"+ (++i));

                    Map<String, String> map = new HashMap<>();
                   map.put(cron, startTime);
                   testCronAlg(map,endTime,processDefinitionId,taskName);
                }
            }
            br.close();
            if(fos!=null){
                fos.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

        private static void testCronAlg(Map<String, String> map,String endTimeStr,String processDefinitionId,String taskName) throws Exception {
            int count = 0;
            List<String> mylist = new ArrayList<>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(++count);
                System.out.println("cron = "+entry.getKey());
                System.out.println("date = "+entry.getValue());
                CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(entry.getKey());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = sdf.parse(entry.getValue());
                Date endTime = sdf.parse(endTimeStr);
                String str2 = null;
                Date mydate = sdf.parse(str2 == null ?entry.getValue():str2);
                while(mydate.before(endTime)) {
                    Date date2 = null;
                    try {
                        date2 = cronSequenceGenerator.next(date);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (date2 != null) {
                        str2 = sdf.format(date2);
                    }
                    date = date2;
                    mydate = date2;
                    String sssssss = "insert into  ods.szj_mrst_schedules(task_name,task_time,process_definition_id,update_flag)  value (`"+taskName+"`,`"+str2+"`,`"+processDefinitionId+"`,"+1+")";
                    mylist.add(sssssss);

                }
            }
            writeFile(mylist);
        }

       public static void writeFile(List<String> str) throws IOException {
           fos = new FileOutputStream(new File("C:\\Users\\70765\\Desktop\\ssssss\\myshuju.txt"));

           byte[] c = new byte[2];
           c[0]=0x0d;
           c[1]=0x0a;

           String c_string = new String(c);
           int k = 0;
           for(String str1 : str){
               System.out.println("---------------k-------------"+k++);
               fos.write((str1+c_string).getBytes());
           }
        }
}
