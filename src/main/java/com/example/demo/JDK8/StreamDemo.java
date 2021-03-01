package com.example.demo.JDK8;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * created by zc  2021/1/4 15:55
 */
@Slf4j
public class StreamDemo {

    private static final ScheduledExecutorService redisMakeUpThreadPool = Executors.newScheduledThreadPool(16);

    static class Stu {
        String name;
        Integer age;

        List<String> hubby = new ArrayList<>();

        public Stu(String name, Integer age, List<String> hubby) {
            this.name = name;
            this.age = age;
            this.hubby = hubby;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public List<String> getHubby() {
            return hubby;
        }

        public void setHubby(List<String> hubby) {
            this.hubby = hubby;
        }
    }

    /**
     * peek()  类似map，但无返回
     * skip(n) 跳过前面n个元素
     */
    public static void peekTest(List<Stu> stus) {
        stus.stream()
                .filter(stu -> stu.getAge() != null)
                .map(stu -> stu.getName())
                .skip(3)
                .peek(System.out::println)
                .count();
    }

    /**
     * 排序比较器
     *
     * @param stus
     */
    public static void sortTest(List<Stu> stus) {
        stus.stream().sorted(Comparator.comparing(Stu::getAge, Comparator.naturalOrder())
                .thenComparing(Stu::getName, Comparator.naturalOrder()))
                .forEach(stu -> {
                    System.out.println(stu.getName() + ":" + stu.getAge());
                });
    }


    public static void main(String[] args) {
        List<Stu> stus1 = new ArrayList<>();
        stus1.add(new Stu("马明", 1, null));
        stus1.add(new Stu("王强", 2, null));
        stus1.add(new Stu("刘红", 3, null));
        stus1.add(new Stu("黄飞", 3, null));

        for (Stu stu : stus1) {
            ArrayList<String> strings = new ArrayList<>();
            stu.setHubby(strings);
            if (stu.getName().equals("马明")) {
                strings.add("打球");
                strings.add("看电影");
                strings.add("唱歌");
            } else if (stu.getName().equals("王强")) {
                strings.add("画画");
            } else {
                strings.add("游泳");
            }
        }

//        sortTest(stus1);
//        peekTest(stus1);

        //stus1.stream().parallel().limit(3).peek(stu1 -> System.out.println(stu1.getName())).count();



    }


}
