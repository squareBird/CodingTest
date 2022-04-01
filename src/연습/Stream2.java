package 연습;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// stream을 통한 정렬
public class Stream2 {
    int age;
    String name;

    int getAge() {
        return age;
    }

    String getName() {
        return name;
    }

    int getNameSize() {
        return name.length();
    }

    public static void main(String[] args) {

        // 배열 선언
        Integer[] temp = {1,2,3,4};
        // 배열을 스트림으로 변환
        Stream<Integer> stream = Arrays.stream(temp);
        // 스트림을 활용한 프린트
        stream.forEach(System.out::println);
        // 스트림을 재사용
        stream.forEach(System.out::println);




//        Stream2[] st = new Stream2[10];
//        for (int i = 0; i < 10; i++) {
//            st[i] = new Stream2();
//            st[i].age = i;
//            st[i].name = (int) ((Math.random() * 10000)) + "";
//        }

//        // 정렬기준 하나
//        System.out.println("1. 정렬기준 하나");
//        Arrays.stream(st)
//                .sorted(Comparator.comparing(Stream2::getName))
//                .forEach(value -> System.out.println("결과 = " + value.getAge() + " " + value.getName()));

//        System.out.println("2. 정렬기준 여러개");
//        // 정렬기준 여러개
//        Arrays.stream(st)
//                .sorted(Comparator.comparing(Stream2::getName).thenComparing(Stream2::getAge))
//                .collect(Collectors.toList())
//                .forEach(value -> System.out.println("결과 = " + value.getAge() + " " + value.getName()));


//        System.out.println("3. 정렬기준 메소드(이름 길이)");
//        // 메소드로 정렬기준 세우기
//        // 이름 길이로
//        Arrays.stream(st)
//                .sorted(Comparator.comparing(Stream2::getNameSize).thenComparing(Stream2::getName))
//                .forEach(value -> System.out.println("결과 = " + value.getAge() + " " + value.getName()));


    }
}
