package 코테_20220312;

import java.util.*;

public class 노드거리 {

    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static List<String> combi = new ArrayList<>();
    static long answer;

    // 조합 생성
    void combination(int[] arr, boolean[] used, int x, int count, String result) {

        if(count==x) {
            combi.add(result);
            return;
        }

        for(int i=0;i<arr.length;i++) {
            if(!used[i]) {
                used[i]=true;
                String nextResult = result+i;
                combination(arr, used, x, count+1, nextResult);
                used[i]=false;
            }
        }

    }

    public long solution(int n, int[][] edges) {

        // 인접리스트 정의
        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        // 조합 생성
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i]=i;
        }
        boolean[] used = new boolean[n];
        combination(arr, used, 3, 0,"");

        // 조합들을 distance 함수를 통해 거리를 구함
        for(String s : combi) {
            int[] temp = new int[3];
            char[] charArr = s.toCharArray();
            for(int i=0;i<3;i++) {
                temp[i] = charArr[i]-'0';
            }

            int ij = dist(temp[0],temp[1]);
            int jk = dist(temp[1],temp[2]);
            int ik = dist(temp[0],temp[2]);

            System.out.println("숫자 : " + temp[0]+" " + temp[1] + " "+temp[2]);

            System.out.println("ij = " + ij);
            System.out.println("jk = " + jk);
            System.out.println("ik = " + ik);


            if((ij+jk)==ik && ik!=0) {
                System.out.println("발동");
                answer++;
            }
            System.out.println("-------------------------------------");

        }

        System.out.println(answer);
        return answer;

    }

    // 노드간의 거리
    public int dist(int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        q.add(a);

        int len = 0;

        while(!q.isEmpty()) {
            int temp = q.poll();

            if(temp==b) {
                return len;
            }

            for(Integer arr : graph.get(temp)) {
                q.add(arr);
            }
            len++;
        }

        return 0;

    }


    public static void main(String[] args) {
        노드거리 a = new 노드거리();
        int[][] arr = {{0,1},{0,2},{1,3},{1,4}};
        a.solution(5,arr);

    }

}
