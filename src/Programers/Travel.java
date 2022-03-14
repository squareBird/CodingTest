import java.util.Collections;
import java.util.ArrayList;

class Travel {

    boolean[] used;
    ArrayList<String> result = new ArrayList<>();

    public String[] solution(String[][] tickets) {

        used = new boolean[tickets.length];
        String route = "ICN";
        dfs(0, "ICN", route, tickets);
        Collections.sort(result);

        String[] answer = result.get(0).split(" ");
        return answer;
    }

    // count는 사용한 티켓의 갯수
    // now는 현재 위치
    // answer은 현재 이동 경로
    // tickets은 티켓들
    void dfs(int count, String now, String route, String[][] tickets) {

        // 처음에는 티켓을 하나도 사용하지 않은 상태로 인천에서 출발
        if(count==tickets.length) {
            result.add(route);
            return;
        }

        for(int i=0;i<tickets.length;i++) {
            // 방문하지 않았으면서 출발지가 현재 위치인 티켓을 찾는다
            if(!used[i] && tickets[i][0].equals(now)) {
                used[i] = true;
                // 사용 티켓수 +, 현재위치를 해당 티켓의 도착지로 변경, 해당 티켓의 도착지로 이동했으니 경로에 추가
                dfs(count+1, tickets[i][1], route + " " + tickets[i][1], tickets);
                used[i] = false;
            }
        }

        return;

    }
}