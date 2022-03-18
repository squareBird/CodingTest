package Programers.Greedy;

import java.util.LinkedList;
import java.util.Queue;

public class 기지국설치 {

    public int solution(int n, int[] stations, int w) {

        int answer = 0;

        // 기지국이 설치된 좌표들
        Queue<Integer> queue = new LinkedList<>();
        for (int i : stations) queue.offer(i);

        // 현재 위치
        int position = 1;

        // 현재 위치가 n에 도달하면 정지
        while (position <= n) {
            // 오른쪽에 기지국이 남아있고 && 기지국의 왼쪽 범위(queue.peek-w)가 position보다 왼쪽이거나 position이면
            if (!queue.isEmpty() && queue.peek() - w <= position) {
                // queue에서 맨 위의 기지국 좌표를 빼고 기지국 오른쪽 범위의 한칸 오른쪽 즉 queue에서 꺼낸 기지국의 범위 밖으로 위치를 이동시킴
                position = queue.poll() + w + 1;
            } else {
                // 기지국에 포함이 안되면
                // 기지국을 하나 설치하는데
                // 가장 효율적으로 설치하기 위해 (기지국왼쪽범위+기지국+기지국오른쪽범위)로 설치하고 position을 이동시킴
                // 예를들어 현재 위치가 1이고 범위가 2일 경우
                // 1,2,3,4,5를 범위로 하고 포지션은 6으로 가야함
                answer += 1;
                position += w + 1 + w;
            }
        }

        return answer;
    }

    public int solution2(int n, int[] stations, int w) {

        int answer = 0;

        // 기지국이 설치된 좌표들
        // queue를 통해 하나씩 가져오던걸 인덱스를 이용해서 + 해가며 다음걸로 이동하는 방식
        int stationIndex = 0;

        // 현재 위치
        int position = 1;

        // 현재 위치가 n에 도달하면 정지
        while (position <= n) {
            // 오른쪽에 기지국이 남아있고 && 기지국의 왼쪽 범위(queue.peek-w)가 position보다 왼쪽이거나 position이면
            // 기존에는 queue에 남아있는지 확인했지만 이번엔 statinIndex가 stationis.length보다 작은지 확인하면됨
            // stationIndex가 더 커지면 stations는 다 확인을 했다는 의미
            if (stationIndex<stations.length && stations[stationIndex] - w <= position) {
                // queue에서 맨 위의 기지국 좌표를 빼고 기지국 오른쪽 범위의 한칸 오른쪽 즉 queue에서 꺼낸 기지국의 범위 밖으로 위치를 이동시킴
                position = stations[stationIndex] + w + 1;
                // queue에서
                stationIndex++;
            } else {
                // 기지국에 포함이 안되면
                // 기지국을 하나 설치하는데
                // 가장 효율적으로 설치하기 위해 (기지국왼쪽범위+기지국+기지국오른쪽범위)로 설치하고 position을 이동시킴
                // 예를들어 현재 위치가 1이고 범위가 2일 경우
                // 1,2,3,4,5를 범위로 하고 포지션은 6으로 가야함
                answer += 1;
                position += w + 1 + w;
            }
        }

        return answer;
    }
}
