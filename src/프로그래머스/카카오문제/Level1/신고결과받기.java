package 프로그래머스.카카오문제.Level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {

        int result[] = new int[id_list.length];

        // 신고 한 것
        Map<String, HashSet<String>> map = new HashMap<>();
        // 신고 당한 것
//        Map<String, Integer>


        for(int i=0;i<id_list.length;i++) {
            map.put(id_list[i], new HashSet<String>());
        }

        for(int i=0;i<report.length;i++) {
            String temp[] = report[i].split(" ");
            map.get(temp[0]).add(temp[1]);
        }

        for(int i=0;i<id_list.length;i++) {
            result[i] = map.get(id_list[i]).size();
        }

        return result;

    }
}