package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;

public class Network {

    static int num = 0;
    static int[] check;

    public static void main(String[] args) {
        Network n = new Network();
        n.solution(3, new int[][]{{1,1,0},{1,1,0},{0,0,1}});
    }

    public int solution(int n, int[][] computers) {

        check = new int[n + 1];

        ArrayList<Integer>[] list = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if(i!=j) {
                    computers[i][j]=1;
                    list[i].add(j);
                }
            }
        }
        int k = 1;
        for(ArrayList<Integer> l : list) {
            System.out.print(k++ + " = ");
            for(Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        // 중복 제거 후 갯수 구하기
        int[] result = Arrays.stream(check).distinct().toArray();
        return result.length;
    }

}
