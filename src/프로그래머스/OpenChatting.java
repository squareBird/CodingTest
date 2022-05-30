package 프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OpenChatting {

    public static void main(String[] args) {

        String[] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        OpenChatting oc = new OpenChatting();
        oc.solution(input);

    }

    public String[] solution(String[] record) {

        // 각 줄별로 행위, uid, 닉네임
        String[][] arr = new String[record.length][3];

        Map<String, String> map = new HashMap<String, String>();

        for (int i = 0; i < record.length; i++) {

            String[] temp = record[i].split(" ");

            for (int j = 0; j < temp.length; j++) {
                arr[i][j] = temp[j];
            }

            // Enter 또는 Chagne일 경우 uid에 따라 닉네임 세팅
            if (arr[i][0].equals("Enter") || arr[i][0].equals("Change")) {
                map.put(arr[i][1], arr[i][2]);
            }

        }

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            if (arr[i][0].equals("Enter")) {
                result.add(map.get(arr[i][1])+"님이 들어왔습니다.");
            }
            if (arr[i][0].equals("Leave")) {
                result.add(map.get(arr[i][1])+"님이 나갔습니다.");
            }
        }

        String[] answer = result.toArray(new String[result.size()]);

        return answer;

    }

}
