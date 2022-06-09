package 프로그래머스;

import java.util.HashMap;
import java.util.Map;

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {

        int len = id_list.length;
        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<id_list.length;i++) {
            map.put(id_list[i], i+1);
        }

        int[][] arr = new int[len][len];

        for(String temp : report) {
            String[] user = temp.split(" ");
            arr[map.get(user[0])-1][map.get(user[1])-1] = 1;
        }

        int[] answer = new int[len];

        for(int i=0;i<len;i++) {
            for(int j=0;j<len;j++) {
                if(arr[j][i]!=0) {
                    answer[j]++;
                }
            }
        }


        return answer;
    }
}