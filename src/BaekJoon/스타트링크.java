package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트링크 {

    private static int n;
    private static int[][] map;
    private static boolean[] used;

    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

//        Scanner scan = new Scanner(System.in);
//        n = scan.nextInt();
//        map = new int[n][n];
//        used = new boolean[n];
//
//        for(int i=0;i<n;i++) {
//            for(int j=0;j<n;j++) {
//                map[i][j] = scan.nextInt();
//            }
//        }
//
//        team(0,0);
//        System.out.println(min);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        used = new boolean[n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        team(0,0);
        System.out.println(min);


    }

    private static void team(int index, int count) {

        // count는 팀이 배정된 사람의 수
        // 팀이 배정된 사람의 수가 n/2 즉 팀이 반반으로 나뉘어졌으면
        // diff() 함수로 최소값 계산
        if(count == n/2) {
            diff();
            return;
        }

        // 팀을 배정
        // 팀이 배정된 사람은 true로 변경
        for(int i=index;i<n;i++) {
            if(!used[i]) {
                used[i] = true;
                team(index+1, count+1);
                used[i] = false;
            }
        }

    }

    private static void diff() {

        int startteam = 0;
        int linkteam = 0;

        // 선수가 6명이면
        // i = 1 ~ 5
        // j = (i+1) ~ 6
        // 안겹치게 해주기 위해 변수 설정
        // 둘다 true인 경우와 false인 경우는 같은팀임
        // 팀별로 점수 계산
        // j가 앞에껀 안쓰므로 중복은 없음
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {

                if (used[i]==true && used[j]==true) {
                    startteam+=map[i][j];
                    startteam+=map[j][i];
                } else if (used[i]==false && used[j]==false) {
                    linkteam+=map[i][j];
                    linkteam+=map[j][i];
                }
            }
        }

        int val = Math.abs(startteam-linkteam);

        if(val==0) {
            System.out.println(val);
            System.exit(0);
        }

        min = Math.min(min, val);

    }
}
