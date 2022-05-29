package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class ROR게임 {

    public static void main(String[] args) {
        ROR게임 r = new ROR게임();
        r.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visit;

    // 최단거리 문제
    // map 배열에 출발지부터 온 값을 계속 추가시켜 나간다.
    public int solution(int[][] maps) {

        Queue<Node> q = new LinkedList<>();
        visit = new boolean[maps.length][maps[0].length];

        q.add(new Node(0,0));
        visit[0][0]=true;

        while(!q.isEmpty()) {
            // 노드 가져옴
            Node n = q.poll();
            System.out.println(n.x + " " + n.y);

            // 해당 노드 기준 상하좌우 확인
            for(int i=0;i<4;i++) {
                int nextX = n.x+dx[i];
                int nextY = n.y+dy[i];

                if(nextX>=0 && nextY>=0 && nextX< maps.length && nextY<maps[0].length &&
                        visit[nextX][nextY]!=true && maps[nextX][nextY]!=0) {
                    visit[nextX][nextY]=true;
                    maps[nextX][nextY] = maps[n.x][n.y]+1;
                    q.add(new Node(nextX, nextY));
                }
            }

        }

        return maps[maps.length-1][maps[0].length-1]!=0 ? maps[maps.length-1][maps[0].length-1] : -1;

    }

    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
