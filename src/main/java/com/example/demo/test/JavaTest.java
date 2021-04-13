package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;

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
    }


    public static void main(String[] args) {

//        Man man1 = new Man("a", 10);
//        Man man2 = new Man("b", 7);
//        Man man3 = new Man("c", 7);
//        Man man4 = new Man("d", 6);

//        ArrayList<Man> men = new ArrayList<>();
//        men.add(man1);
//        men.add(man2);
//        men.add(man3);
//        men.add(man4);

//        Comparator<Man> reversed = Comparator.comparing(Man::getName).reversed();
//
//        List<Man> collect = men.stream()
//                .sorted(Comparator.comparing(Man::getAge)
//                .thenComparing(reversed))
//                .collect(Collectors.toList());


        int i = 11;
        System.out.println(Math.floor(i/2));
        System.out.println(i%2);


    }
}
