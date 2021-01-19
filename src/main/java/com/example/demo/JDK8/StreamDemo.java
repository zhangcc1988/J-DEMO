package com.example.demo.JDK8;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;

/**
 * created by zc  2021/1/4 15:55
 */
@Slf4j
public class StreamDemo {

    private static final ScheduledExecutorService redisMakeUpThreadPool = Executors.newScheduledThreadPool(16);


    static class stu {
        String name;
        Integer age;

        List<String> hubby = new ArrayList<>();

        public stu(String name, Integer age, List<String> hubby) {
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


    public static void main(String[] args) {
        ArrayList<stu> stus = new ArrayList<>();


//        List<stu> collect = stus.stream().filter(stu -> {
//            if (stu.getName().equals("小天")) {
//                stu.setAge(100);
//            }
//            return stu.getAge()<100;
//        }).sorted((o1, o2) -> o1.getAge().compareTo(o2.getAge())).collect(Collectors.toList());
//
//        for (stu stu : collect) {
//            System.out.println(stu.getName()+":"+stu.getAge());
//        }
//
//        stu stu1 = stus.stream().filter(stu -> stu.getAge() != null).min((o1, o2) -> o1.getAge().compareTo(o2.getAge())).orElse(null);
//
//        System.out.println(stu1.getName()+":"+stu1.getAge());


        List<stu> stus1 = new ArrayList<>();
        stus1.add(new stu("马明",1,null));
        stus1.add(new stu("王强",2,null));
        stus1.add(new stu("刘红",3,null));
        stus1.add(new stu("黄飞",3,null));


        for (stu stu : stus1) {
            ArrayList<String> strings = new ArrayList<>();
            stu.setHubby(strings);
            if (stu.getName().equals("马明")) {
                strings.add("打球");
                strings.add("看电影");
                strings.add("唱歌");
            }else if (stu.getName().equals("王强")){
                strings.add("画画");
            }else {
                strings.add("游泳");
            }
        }

        stus1.stream().sorted(Comparator.comparing(stu::getAge,Comparator.naturalOrder())
                .thenComparing(stu::getName,Comparator.naturalOrder()))
                .forEach(stu -> {
                    System.out.println(stu.getName()+":"+stu.getAge());
                });


        //stus1.stream().flatMap(stu -> stu.getHubby().stream()).collect(Collectors.toList()).forEach(System.out::println);


        List<stu> collect = stus1.stream().filter(stu -> stu.getAge() > 100).collect(Collectors.toList());

        collect.forEach(System.out::println);

    }
}
