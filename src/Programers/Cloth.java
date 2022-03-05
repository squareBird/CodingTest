package Programers;

import java.util.HashMap;

public class Cloth {

    class Solution {
        public int solution(String[][] clothes) {

            // 1. 하나만 입는 경우
            // 2. 2개 입는 경우
            // 3. n개 입는 경우

            HashMap<String, Integer> hm = new HashMap<>();
            // 옷을 정류별로 구분
            for(String[] s : clothes) {
                if(hm.containsKey(s[1])) {
                    hm.put(s[1],hm.get(s[1])+1);
                } else {
                    hm.put(s[1], 1);
                }
            }

            int answer = 1;

            // hm.value()의 값들은 부위별 옷의 종류 수
            // 예를들면 answer*=i는
            // 차례로 헤드기어, 상의, 하의의 경우의 수들과 같다
            // 모자 2개, 상의 2개, 하의 2개 있으면 경우의수는 2*2*2
            // 그런데 안입는 경우도 있으니 +1을 해준다
            for(int i : hm.values()) {
                answer*=i+1;
            }

            // 아무것도 안입는 경우의 수는 없으니 -1
            return answer-1;
        }
    }
    public static void main(String args[]) {

        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

    }

}
