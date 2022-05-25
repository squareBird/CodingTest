package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 바이러스 {

    private static int N; // 컴퓨터의 수 최대 100, 번호는 1부터
    private static int M; // 연결되어있는 컴퓨터 쌍의 수
    private static boolean[] visit;
    private static List<Integer>[] list;
    private static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        visit = new boolean[N+1];
        visit[0]=true; // 0은 안씀

        list = new ArrayList[N+1]; // 컴퓨터 갯수 +1만큼 생성, 1부터 계산하기 쉽도록
        for(int i=0;i<list.length;i++) {
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<M;i++) {
            int[] temp = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list[temp[0]].add(temp[1]);
            list[temp[1]].add(temp[0]);
        }

        visit[1]=true; // 1은 처음부터 감염된 상태로 들어가므로 true
        dfs(1);
        System.out.println(result);

    }

    static void dfs(int start) {
        for(int i=1;i<=N;i++) {
            if(!visit[i] && list[start].contains(i)) {
                visit[i]=true;
                result++;
                dfs(i);
            }
        }
    }

}
