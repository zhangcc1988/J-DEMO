package com.example.demo.JDK8;

import java.util.ArrayList;

/**
 * created by zc  2021/1/4 15:55
 */
public class StreamDemo {

    static class stu {
        String name;
        Integer age;

        public stu(String name, Integer age) {
            this.name = name;
            this.age = age;
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
    }


    public static void main(String[] args) {
        ArrayList<stu> stus = new ArrayList<>();
        stus.add(new stu("小明", 1));
        stus.add(new stu("小黑", null));
        stus.add(new stu("小花", 19));
        stus.add(new stu("小黄", 18));
        stus.add(new stu("小天", 16));
        stus.add(new stu("小超", 12));


//        List<stu> collect = stus.stream().filter(stu -> {
//            if (stu.getName().equals("小天")) {
//                stu.setAge(100);
//            }
//            return stu.getAge()<100;
//        }).sorted((o1, o2) -> o1.getAge().compareTo(o2.getAge())).collect(Collectors.toList());

//        for (stu stu : collect) {
//            System.out.println(stu.getName()+":"+stu.getAge());
//        }

        stu stu1 = stus.stream().filter(stu -> stu.getAge() != null).min((o1, o2) -> o1.getAge().compareTo(o2.getAge())).orElse(null);

        System.out.println(stu1.getName()+":"+stu1.getAge());


        System.out.println("test");
    }
}
