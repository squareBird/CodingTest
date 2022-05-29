package 기타;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class 부등호 {

    private static int n; // 부등호의 갯수
    private static boolean[] visit = new boolean[10]; // 방문처리
    private static char[] signs; // 부등호
    private static List<String> result = new ArrayList<>();

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        // input 값 받아오기
        n = scan.nextInt();
        signs = new char[n];

        for(int i=0;i<n;i++) {
            // scan.next를 이용해서 받아오면 String이 받아와짐
            // char로 변환
            signs[i] = scan.next().charAt(0);
        }

        dfs("",0);

        // 결과값 정렬
        Collections.sort(result);
        System.out.println(result.get(result.size() -1)); //  최대값
        System.out.println(result.get(0));
    }

    private static void dfs(String num, int depth) {

        // 부등호가 n개이면 숫자는 n+1개여야 함
        // 숫자의 갯수 즉 뎁스가 n+1이 되면 결과를 result에 넣고 dfs 종료
        if(depth == n+1) {
            result.add(num);
            return;
        }

        for(int i=0; i<=9; i++) {
            // 일단 숫자가 하나도 없으면 맨앞에 아무 숫자나 넣음(depth가 0일 경우)
            // 숫자는 0~9까지 가능
            // 1. 숫자 i가 아직 사용되지 않았고 (!visit[i])
            // 2. 가장 마지막에 들어온 숫자(num.charAt(num.length()-1) - '0')와 i를 부등호를 통해 비교 했을 때 부등호와 결과가 일치하면
            // 3. 일단 넣어봄
            // 분기가 쭉 뻗어나감 예를들어 2<?와 일치하는것은 3~9이므로 3~9를 for문으로 순서대로 쭉 넣는 형태!
            if(depth ==0 ||
                    !visit[i] && compare(num.charAt(num.length()-1) - '0', i, signs[depth-1])) {
                visit[i]=true;
                dfs(num+i, depth+1);
                visit[i]=false;
            }
        }
    }

    private static boolean compare(int a, int b, char c) {
        if(c == '<') return a<b;
        else return a>b;
    }

}
