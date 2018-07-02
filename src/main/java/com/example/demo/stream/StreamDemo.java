package com.example.demo.stream;

import static java.util.stream.Collectors.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by OL-PC on 2018/05/14.
 */
public class StreamDemo {
    public static void main(String[] args) {
//        Set<Integer> set = new HashSet<>();
//        Random ran = new Random();
//        int a = ran.nextInt(1001);
//        int temp;
//        long begin = System.currentTimeMillis();
//        while (set.size() <=900){
//            temp = ran.nextInt(1001);
//            set.add(temp);
//            System.out.println(temp);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(end - begin);
//        test1();
//        test2();
        summaryTest();
    }
    public static void test2(){
        ArrayList<String> list = new ArrayList<>();
        list.add("123");
        list.add("123");
        list.add("234");
        list.add("345");
        list.add("345");
        list.add("456");
        list.add("456");
        HashSet<String> strings = new HashSet<>(list);
        list.clear();
        list.addAll(strings);
        System.out.println(list);
    }
    public static void test1(){
        List<Dish> list = getDishes();
        List<String> sorted =
                list.stream().filter(d -> d.getCalories() <= 500)
                .sorted(Comparator.comparing(Dish::getCalories)
                        .thenComparing(Dish::getName))
                .map(Dish::getName).collect(Collectors.toList());
        System.out.println(Arrays.toString(sorted.toArray()));

        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> list1 = words.stream().map(s -> s.length()).collect(Collectors.toList());
        System.out.println(Arrays.toString(list1.toArray()));
        List<String> list2 = words.stream().map(s ->s.split("")).flatMap((s) ->Arrays.stream(s)).collect(Collectors.toList());

        Integer count = words.stream().map(i -> 1).reduce(0,Integer::sum);
        System.out.println(count);

        List<Integer> integers = Arrays.asList(1,2,3);
        List<Integer> integers1 = Arrays.asList(2,4);
        List<Double> integerList = integers.stream().map(i -> Math.pow(i,2)).collect(Collectors.toList());
        System.out.println(Arrays.toString(integerList.toArray()));

        List<int[]> ints = integers.stream().flatMap(i -> integers1.stream().filter(j -> (i + j)%3==0).map(j -> new int[]{i,j})).collect(Collectors.toList());
        System.out.println(Arrays.toString(ints.toArray()));


        //勾股流
        List<Integer> num1 = Arrays.asList(3, 5, 6);
        List<Integer> num2 = Arrays.asList(4, 12, 8);
        IntStream.rangeClosed(1,100).boxed()
                .flatMap(a ->IntStream.rangeClosed(a,100)
                        .filter(b ->Math.sqrt(a*a + b*b) % 1 == 0)
                        .filter(b -> Math.sqrt(a*a + b*b) <= 100)
                        .mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a*a + b*b)}))
                .forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));
    }
    public static List<Dish> getDishes(){
        List<Dish> list = new ArrayList<>();
        Dish milk = new Dish(450,"milk");
        Dish meet = new Dish(450,"meet");
        Dish maet = new Dish(450,"maet");
        Dish bee = new Dish(500,"bee");
        Dish cola = new Dish(800,"cola");
        list.add(milk);
        list.add(meet);
        list.add(maet);
        list.add(bee);
        list.add(cola);
        return list;
    }
    public static void summaryTest(){
        List<Dish> list = getDishes();
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> maxDish = list.stream().collect(maxBy(dishComparator));
        System.out.println("最大 ->" + maxDish.get().toString());

        long sum = list.stream().collect(summingInt(d -> d.getCalories()));
        System.out.println("求和 ->" + sum);
        double average = list.stream().collect(averagingDouble(d -> d.getCalories()));
        System.out.println("平均 ->" + average);
        long count = list.stream().collect(counting());
        System.out.println("计数 ->" + count);
        IntSummaryStatistics statistics = list.stream().collect(summarizingInt(d -> d.getCalories()));
        System.out.println("统计 ->" + statistics);

        String str = list.stream().map(d -> d.getName()).collect(joining(","));
        System.out.println("拼接串 ->" + str);
    }
    static class Dish{
        int calories;
        String name;

        public Dish(int calories, String name) {
            this.calories = calories;
            this.name = name;
        }

        public int getCalories() {
            return calories;
        }

        public void setCalories(int calories) {
            this.calories = calories;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dish{" +
                    "calories=" + calories +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
