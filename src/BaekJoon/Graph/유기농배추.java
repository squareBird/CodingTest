package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 유기농배추 {

    static int T;
    static int M;
    static int N;
    static int K;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 테스트케이스 수
        T = Integer.parseInt(bf.readLine());
        for(int i=0;i<T;i++) {

            // 테스트케이스별 변수
            int[] param = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            M = param[0];
            N = param[1];
            K = param[2];

            // map과 visit 초기화
            map = new int[M][N];
            visit = new boolean[M][N];

            // map 세팅
            for(int j=0;j<K;j++) {
                int[] temp = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                map[temp[0]][temp[1]]=1;
            }

            int count=0;
            for(int p=0;p<M;p++) {
                for(int q=0;q<N;q++) {
                    if(map[p][q]==1 && !visit[p][q]) {
                      dfs(p,q);
                      count++; // 배추 한 모음을 찾았으면 count++
                    }
                }
            }
            result.add(count);
        }

        for(Integer i : result) {
            System.out.println(i);
        }
    }

    static void dfs(int x, int y) {

        visit[x][y]=true;

        for(int i=0;i<4;i++) {

            int nextX = x+dx[i];
            int nextY = y+dy[i];

            if(nextX>=0 && nextY>=0 && nextX<M && nextY<N) {
                if(!visit[nextX][nextY] && map[nextX][nextY]==1) {
                    dfs(nextX, nextY);
                }
            }
        }
    }



}
