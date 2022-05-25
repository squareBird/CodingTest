package BaekJoon.Graph;

import java.util.*;

public class 단지번호_bfs {

    private static int N;
    private static int[][] map;
    private static boolean[][] visit;
    private static int aptNum; // 단지 수
    private static int count;
    private static List<Integer> result; // 단지별 아파트 수

    private static int[] dx = {-1,1,0,0}; // 좌우
    private static int[] dy = {0,0,-1,1}; // 상하

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        map = new int[N][N];
        visit = new boolean[N][N];
        result = new ArrayList<>();

        for(int i=0;i<N;i++) {
            String temp = scan.next();
            map[i] = Arrays.stream(temp.split("")).mapToInt(Integer::parseInt).toArray();
        }

        aptNum=0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j]==1 && !visit[i][j]) {
                    count=0; // 단지를 하나 찾을때마다 0부터 카운트
                    aptNum++; // for문을 한바퀴 돌고 나오면 단지 하나를 모두 찾은것이므로 다음 단지부터는 aptNum을 ++
                    bfs(i,j);
                    result.add(count);
                }
            }
        }

        System.out.println(aptNum);
        result.stream().sorted().forEach(answer -> System.out.println(answer));

    }

    static void bfs(int x, int y) {

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visit[x][y]=true;
        count++; // 하나의 단지를 찾은 상태에서 들어왔으므로 처음에 값 ++

        while(!q.isEmpty()) {
            // 밖의 for문을 돌다가 단지가 존재하는걸 찾았으므로 해당 단지의 아파트 갯수를 세기 위한 시작점(단지를 찾은 점)
            Node temp = q.poll();

            for(int i=0;i<4;i++) {
                // 상하좌우로 다음 위치
                int nextX = temp.x+dx[i];
                int nextY = temp.y+dy[i];

                if(nextX>=0 && nextY>=0 && nextX<N && nextY<N) { // 좌표가 map 범위를 초과하지 않고
                    if(!visit[nextX][nextY] && map[nextX][nextY]==1) { // 아직 방문하지 않았으면서 map의 값이 1이면 즉 아파트가 존재하면
                        visit[nextX][nextY]=true; // 해당 아파트 방문처리
                        q.add(new Node(nextX, nextY)); // 큐에 해당 좌표를 더함
                        count++; // 단지 갯수 ++
                    }
                }
            }
        }



    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
