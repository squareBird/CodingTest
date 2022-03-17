package BaekJoon;

import java.util.*;

public class 단지번호_dfs {

    private static int N;
    private static int[][] map;
    private static boolean[][] visit;
    private static int aptNum; // 단지 수
    private static int count;
    private static List<Integer> result; // 단지별 아파트 수

    private static int[] dx = {-1,1,0,0}; // 좌우
    private static int[] dy = {0,0,-1,1}; // 상하

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        map = new int[N][N];
        visit = new boolean[N][N];
        result = new ArrayList<>();
        for(int i=0;i<N;i++) {
            String temp = scan.next();
            map[i] = Arrays.stream(temp.split("")).mapToInt(Integer::parseInt).toArray();
        }

        aptNum=0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j]==1 && !visit[i][j]) {
                    count=0;
                    aptNum++; // 단지수 +
                    /**
                     * 1인것을 하나 찾으면 dfs 함수로 들어감
                     * 주변의 1인것의 갯수를 모두 세서 나옴
                     */
                    dfs(i,j);
                    result.add(count);
                }
            }
        }

        Collections.sort(result);

        System.out.println(aptNum);
        result.stream().forEach(answer -> System.out.println(answer));
    }

    static void dfs(int x, int y) {

        visit[x][y] = true;
        count++; // 단지에 아파트가 몇개 있는지 추가
        map[x][y]=aptNum;

        for(int i=0;i<4;i++) {
            int nextX = x+dx[i];
            int nextY = y+dy[i];

            if(nextX>=0 && nextY>=0 && nextX<N && nextY<N) {
                if(!visit[nextX][nextY] && map[nextX][nextY]==1) {
                    dfs(nextX, nextY);
                }
            }
        }
    }
}
