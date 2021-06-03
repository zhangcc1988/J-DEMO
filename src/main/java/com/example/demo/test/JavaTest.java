package com.example.demo.test;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * created by zc  2021/1/15 15:14
 */
@Slf4j
public class JavaTest {

    static class Man {

        String name;
        Integer age;

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

        public Man(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Man() {
        }
    }

    @Data
    static class B {
        String name;
        Integer age;
        Integer sex;

        List<String> hobby;
    }


    public static void main(String[] args) {


//        Comparator<Man> reversed = Comparator.comparing(Man::getName).reversed();
//
//        List<Man> collect = men.stream()
//                .sorted(Comparator.comparing(Man::getAge)
//                .thenComparing(reversed))
//                .collect(Collectors.toList());

//        String s = JSON.toJSONString(men, SerializerFeature.WriteMapNullValue);
//        System.out.println(s);


//        List<Man> collect = men.stream().filter(man -> true).collect(Collectors.toList());
//
//        for (Man man : collect) {
//            System.out.println(man.toString());
//        }


        Integer flag = 0;

        System.out.println(null != flag && flag > 1 || flag < 2);


    }


}
