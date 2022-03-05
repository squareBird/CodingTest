package Programers.Hash;

import java.util.HashMap;
import java.util.Map;

public class Maraton {

    public static void main(String[] args) {

        Maraton m = new Maraton();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        m.solution(participant, completion);

    }

    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();

        for(String s : participant) {
            map.put(s, map.getOrDefault(s,0)+1);
        }

        for(String s : completion) {
            if(map.get(s)==1) {
                map.remove(s);
            } else {
                map.put(s, map.get(s)-1);
            }
        }

        for(String s : map.keySet()) {
            return s;
        }

        return null;

    }

}
