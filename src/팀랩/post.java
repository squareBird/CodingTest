package 팀랩;

import java.util.HashSet;

public class post {

    static HashSet<Integer> result = new HashSet<>();

    public static void main(String[] args) {

        int n=0;

        for(int i=0;i<=30;i++) {
            for(int j=0;j<=40;j++) {
                for(int k=0;k<=10;k++) {
                    int coinA = (205*i);
                    int coinB = (82*j);
                    int coinC = (30*k);
                    int answer = coinA+coinB+coinC;
                    result.add(answer);
                    n++;
                }
            }
        }
        System.out.println("n = " + n);
        System.out.println(result.size());
    }

}
