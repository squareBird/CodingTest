package 프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class 일이사나라 {

    public String solution(int n) {

        // 3으로 나눈 나머지에 따라 값 결정..
        // 3으로 나눴을 때 1=1, 2=2, 0=4

//        String answer = "";
        ArrayList<String> arr = new ArrayList<>();

        while(n!=0) {

            int temp = n%3;
            n /= 3;

            if(temp==0) {
                // 자리수 보정
                n--;
                temp=4;
            }

            arr.add(temp+"");

//            answer = temp+answer;
        }

        Collections.reverse(arr);

        // reduce = 반복
        // isPresent = null check
        // get() <T> 타입으로 값 받음 reduce 한거 옵셔널이므로 get으로 T 즉 String 형태 값 받아옴옴
       return arr.stream().reduce(String::concat).isPresent() ? arr.stream().reduce(String::concat).get() : "";




//        return answer;
    }

}
