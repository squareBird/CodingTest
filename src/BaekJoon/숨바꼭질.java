package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.in;

public class 숨바꼭질 {

    private static int N;
    private static int K;
    private static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(in));

        N= Integer.parseInt(bf.readLine());
        K= Integer.parseInt(bf.readLine());
        dp = new int[2*K];

        dp[N]=0;
        for(int i=N;i>=0;i--) {
            dp[i-1]=dp[i]+1;
        }

    }

//    private static void bfs(int point, int count) {
//
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(point);
//
//        while(!queue.isEmpty()) {
//            int temp = queue.poll();
//        }
//
//    }
}
