package Action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {
    public static void main(String[] args) throws Exception {
 /*       String count="3";
        int x=Integer.valueOf(count);
        String a="山东";
        String b="山东";
        String c="山东";
        String d=a+b+c;
        System.out.println(d+","+d.length());
        String y=String.valueOf(x);
        System.out.println(count.equals("3"));
        System.out.println(x);
        System.out.println(y);*/
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date()));
        String str=df.format(new Date());

        System.out.println(str);
        Date d=df.parse(str);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(d);
        rightNow.add(Calendar.MONTH,3);//日期加3个月
        Date dt1=rightNow.getTime();
        String reStr = df.format(dt1);
        System.out.println(reStr);



        String w="w";
        System.out.println(w.equals("1")==false);


    }
}
