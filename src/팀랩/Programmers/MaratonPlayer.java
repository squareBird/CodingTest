package Programmers;


import java.util.HashMap;
import java.util.Map;

// getOrDefault를 활용하는 방법도 있음!
// 파이썬은 딕셔너리로 푸는건가??
public class MaratonPlayer {

    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> hm = new HashMap<>();

        for(String player : participant) {

            // hm에 값을 집어넣는데 키는 plyaer로 넣고 value는 만약에
            // 키가 player인 값이 맵에 없으면 기본값 0+1해서 1이 들어가고 있으면 그값 +1
            hm.put(player, hm.getOrDefault(player, 0) + 1);

//            if(hm.containsKey(s)) {
//                hm.put(s, hm.get(s)+1);
//            } else {
//                hm.put(s,1);
//            }

        }

        for(String s : completion) {
            if(hm.get(s)==1) {
                hm.remove(s);
            } else {
                hm.put(s,hm.get(s)-1);
            }
        }

        String answer = null;

        for(String s : hm.keySet()) {
            answer = s;
        }


        return answer;
    }

    public static void main(String args[]) {


        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        MaratonPlayer m = new MaratonPlayer();
        m.solution(participant, completion);


    }


}
