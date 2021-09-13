package com.example.demo.test;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

/**
 * created by zc  2021/1/15 15:14
 */
@Slf4j
public class JavaTest {

    static class Man {

        Integer score;
        Integer age;
        Date birthDay;

        List<String>  hobby;

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Date getBirthDay() {
            return birthDay;
        }

        public void setBirthDay(Date birthDay) {
            this.birthDay = birthDay;
        }


        public List<String> getHobby() {
            return hobby;
        }

        public void setHobby(List<String> hobby) {
            this.hobby = hobby;
        }

        public Man(Integer score, Integer age, Date birthDay) {
            this.score = score;
            this.age = age;
            this.birthDay = birthDay;
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


    public static void fn(String n){
        n = "xixiix";
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


//        String l =  "244685293611304345936";
//
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(l);
//        if (stringBuilder.length() > String.valueOf(Long.MAX_VALUE).length()){
//            String substring = stringBuilder.substring(0, String.valueOf(Long.MAX_VALUE).length());
//
//            System.out.println(Long.parseLong(substring));
//        }


//
//        Map<String, Integer> collect = array.stream().collect(Collectors.toMap(Man::getName, Man::getAge));
//        TreeMap<String, Man> treeMap = array.stream().collect(Collectors.toMap(Man::getName, Function.identity(), (man, man2) -> man, TreeMap::new));
//
//        System.out.println(JSON.toJSONString(collect));
//        System.out.println(JSON.toJSONString(treeMap));


//        String s = "231.gif";
//        System.out.println(s.matches("[1-9]\\d*|0"));
//
//        boolean gif = s.substring(s.lastIndexOf(".") + 1).equals("gif");
//        System.out.println(gif);
//        ArrayList<String> h = new ArrayList<>();
//        h.add("打球");
//        h.add("听歌");
//        Man man = new Man();
//        man.setHobby(h);
//        System.out.println(JSON.toJSONString(man.getHobby()));
//
//        h.add("玩游戏");
//
//        System.out.println(JSON.toJSONString(man.getHobby()));



    }





}
