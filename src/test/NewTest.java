package test;

/**
 * Created by Bill on 2016/11/25.
 * Email androidBaoCP@163.com
 */
public class NewTest {


    public void change1(int i) {
        i = 1234;
    }

    public void change2(BirthDay b) {
        b = new BirthDay(2012, 10, 2);
    }

    public void change3(BirthDay birthDay) {
        birthDay.setDay(10);
    }

    public static void main(String... args) {
        NewTest test = new NewTest();
        int data = 9;
        BirthDay birthDay = new BirthDay(2010, 1, 2);
        BirthDay birthDay1 = new BirthDay(2001, 2, 4);
        test.change1(data);
        test.change2(birthDay);
        test.change3(birthDay1);
        System.out.println(data);
        System.out.println(birthDay.getYear() + birthDay.getMouth() + birthDay.getDay());
        System.out.println(birthDay1.getDay());
    }
}

class BirthDay {
    private int year;
    private int mouth;
    private int day;

    public BirthDay(int year, int mouth, int day) {
        this.year = year;
        this.mouth = mouth;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMouth() {
        return mouth;
    }

    public void setMouth(int mouth) {
        this.mouth = mouth;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}