package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 단지번호 {

    private static int N;
    private static int[][] map;
    private static boolean[][] visit;
    private static int aptNum=0; // 단지 수

    private static int[] dx = {-1,1,0,0}; // 좌우
    private static int[] dy = {0,0,-1,1}; // 상하

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        map = new int[N][N];
        visit = new boolean[N][N];
        for(int i=0;i<N;i++) {
            String temp = scan.next();
            map[i] = Arrays.stream(temp.split("")).mapToInt(Integer::parseInt).toArray();
        }

        visit[0][0]=true;
        dfs(0,0);
        System.out.println();

    }

    static void dfs(int x, int y) {

        for(int i=0;i<4;i++) {
            int nextX = x+dx[i];
            int nextY = y+dy[i];

            if(nextX<0 || nextX>=N || nextY<0 || nextY>N)
                continue;
            if(visit[nextX][nextY] || map[nextX][nextY]==0)
                continue;

            map[nextX][nextY]=count;
            visit[nextX][nextY]=true;
            dfs(nextX, nextY);
            count++;
        }

    }
}
