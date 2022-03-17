package BaekJoon.Graph;

import java.util.*;

public class 미로탐색 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dx = {-1,1,0,0}; // 상하
    private static int[] dy = {0,0,-1,1}; // 좌우
    private static int result = 0;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();
        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0;i<N;i++) {
            String temp = scan.next();
            map[i]=Arrays.stream(temp.split("")).mapToInt(Integer::parseInt).toArray();
        }

        visit[0][0]=true;
        bfs(0,0);
        System.out.println(map[N-1][M-1]);

    }

    private static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();

            for(int i=0;i<4;i++) {
                int nextX = temp[0]+dx[i];
                int nextY = temp[1]+dy[i];
                // 점이 map 범위를 초과하면 다음점
                if(nextX<0 || nextX>=N || nextY<0 || nextY>=M) {
                    continue;
                }
                // 이미 방문했거나 못가는 곳이면 0
                if(visit[nextX][nextY] ||  map[nextX][nextY]==0) {
                    continue;
                }
                // 큐에 아직 방문하지 않았고 map이 0이 아닌곳을 찾음(현재 점에서 다음에 갈 수 있는곳)
                // 현재 점에서 다음에 갈 수 있는곳을 큐에 추가
                queue.add(new int[]{nextX, nextY});
                // 다음에 갈 수 있는 곳에는 현재 위치의 숫자+1
                map[nextX][nextY]=map[nextX-dx[i]][nextY-dy[i]]+1;
                // 방문처리 해서 다시 안가게 해줌
                visit[nextX][nextY]=true;
            }


        }

    }


}
