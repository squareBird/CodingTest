package BaekJoon;

import java.util.Scanner;

public class 로또 {

    private static int n;
    private static int[] arr;
    private static boolean[] used;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while(true) {
            n = scan.nextInt();
            arr = new int[n];
            used = new boolean[n];

            if(n==0) {
                break;
            }

            for(int i=0;i<n;i++) {
                arr[i] = scan.nextInt();
            }

            dfs(0,0);
            System.out.println();

        }

    }

    // index = 다음번에 들어갈 숫자의 인덱스
    // depth = 사용한 숫자
    private static void dfs(int index, int depth) {

        if(depth == 6){
            for (int i = 0; i <n ; i++) {
                if(used[i]){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }

        for(int i=index;i<n;i++) {
            used[i]=true;
            // index부터하면 이전것도 써버리므로 안됨..
            dfs(i+1, depth+1);
            // 출력하고 돌아올땐 다시 사용해야 하므로 false로
            used[i] = false;
        }

    }
}
