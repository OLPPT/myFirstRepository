package spittr.web;

import java.sql.SQLPermission;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by OL-PC on 2018/03/28.
 */
public class NumerTest<Y> {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<? super B> aa = new ArrayList<>();
        aa.add(new C());
        System.out.println(aa.get(0).getClass().getName());
    }
    public static<Y extends A > void aa(){

    }
    static class A{

    }
    static class B extends A{

    }
    static class C extends B{

    }
}
