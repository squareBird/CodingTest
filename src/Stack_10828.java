package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.in;
import static java.lang.System.setOut;

public class Stack_10828 {
    /*
        push X: 정수 X를 스택에 넣는 연산이다.
        pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        size: 스택에 들어있는 정수의 개수를 출력한다.
        empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
        top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        Stack<Integer> list = new Stack<>();

        for(int i=0;i<N;i++) {

            String temp = scan.nextLine();

            if(temp.startsWith("push")) {
                int num = Integer.parseInt(Arrays.asList(temp.split(" ")).get(1));
                list.add(num);
            }

            if(temp.startsWith("pop")) {
                if(list.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(list.pop());
            }

            if(temp.startsWith("size")) {
                System.out.println(list.size());
            }

            if(temp.startsWith("empty")) {
                if(list.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }

            if(temp.startsWith("top")) {
                if(list.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(list.peek());
            }
        }
    }
}
