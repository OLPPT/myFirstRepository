package com.example.demo.quartz;

import java.util.Scanner;

/**
 * Created by OL-PC on 2018/07/10.
 */
public class Test {
    public static void main(String[] args) {
        test2();
    }
    public static void test1(){
        int ri,repeat,n,day,buy;
        float sum,ave;
        Scanner in = new Scanner(System.in);
        repeat = in.nextInt();
        for (ri = 1;ri <= repeat;ri++){
            n = in.nextInt();
            buy = 0;
            day = 0;
            int current = 0;
            while (current < n){
                current = (int)Math.pow(2,++day);
                buy += current;
            }
            sum = buy * 0.8f;
            ave =  sum/day;
            System.out.println((long)(ave*100 + 0.5)/100.);
        }
    }
    public static void test2(){
        int ri,repeat,i,count;
        String str;
        Scanner in = new Scanner(System.in);
        repeat = in.nextInt();
        for (ri = 1;ri <=repeat;ri++){
            str=in.next();

            //System.out.println(count);
        }
    }
}
