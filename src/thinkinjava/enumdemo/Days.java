package thinkinjava.enumdemo;

/**
 * Created by Bill on 2017/4/22.
 * Email androidBaoCP@163.com
 */
public enum Days {
    SUNDAY("sunday"),
    MONDAY("monday"),
    TUESDAY("tuesday"),
    WEDNESDAY("wednesday"),
    THURSDAY("thursday"),
    FRIDAY("friday"),
    SATURDAY("saturday");
    String string;
    Days(String s){
        string = s;
    }
    public static void main(String[] args){
        for (Days days:Days.values()){
            System.out.println(days.name()+" "+days.ordinal());
        }
        System.out.println(Days.valueOf("MONDAY"));
        System.out.println(Days.valueOf(Days.class,"SUNDAY"));
    }
}
