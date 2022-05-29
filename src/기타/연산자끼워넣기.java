package 기타;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 연산자끼워넣기 {

    private static int n;
    private static int[] num;
    private static int[] symbol = new int[4];
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        num = new int[n];

        for(int i=0;i<n;i++) {
            num[i] = scan.nextInt();
        }

        // 덧셈, 뺄셈, 곱셈, 나눗셈
        for(int i=0;i<4;i++) {
            symbol[i] = scan.nextInt();
        }

        dfs(1, num[0]);

        Collections.sort(result);
        System.out.println(result.get(result.size()-1));
        System.out.println(result.get(0));


    }
    // num = 현재 결과값... index = 깊이
    private static void dfs(int index, int number) {


        if(index==n) {
            result.add(number);
            return;
        }

        for(int i=0;i<4;i++) {
            // 연산자의 갯수가 1개 이상인 경우
            if(symbol[i]>0) {
                // 연산자 갯수 감소
                symbol[i]--;
                switch(i) {
                    case 0: dfs(index+1, number + num[index]); break;
                    case 1: dfs(index+1, number - num[index]); break;
                    case 2: dfs(index+1, number * num[index]); break;
                    case 3: dfs(index+1, number / num[index]); break;
                }
                // 재귀문 빠져나온 후 연산자 갯수 원상복구
                symbol[i]++;
            }
        }

    }
}
