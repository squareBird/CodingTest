package 기타;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class 퇴사dp {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] T = new int[N+10]; // 상담 소요시간
        int[] P = new int[N+10];  // 받을 수 있는 금액
        int[] dp = new int[N+10]; // 해당 날짜의 최대 금액

        int max = 0;

        String[] str;

        for(int i=1;i<N;i++) {
            str = bf.readLine().split(" ");
            T[i] = Integer.parseInt(str[0]);
            P[i] = Integer.parseInt(str[1]);
        }


        for(int i=1;i<=N+1;i++) {

            dp[i] = Math.max(dp[i], max);

            dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i]+P[i]);
            max = Math.max(max, dp[i]);

        }


    }
}
