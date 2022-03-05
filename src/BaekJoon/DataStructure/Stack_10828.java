package BaekJoon.DataStructure;

import java.util.Scanner;
import java.util.Stack;

public class Stack_10828 {
/*
    push X: 정수 X를 스택에 넣는 연산이다.
    pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 스택에 들어있는 정수의 개수를 출력한다.
    empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
    top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/
    static void solution() {

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Stack<Integer> s = new Stack<>();

        for(int i=0;i<n;i++) {
            String temp = scan.next();

            if(temp.startsWith("pop")) {
                String[] temp2 = temp.split(" ");
                s.push(Integer.parseInt(temp2[1]));
            }

            if(temp.equals("pop")) {
                if(s.peek()==null) {
                    System.out.println(-1);
                } else {
                    System.out.println(s.pop());
                }
            }



        }



    }

}
