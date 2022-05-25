package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.in;

public class 데스나이트 {

    static int N;
    static int[][] map;
    static int[] dr = {-2, -2, 0, 0, 2, 2,};
    static int[] dc = {-1, +1, -2, +2, -1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(in));

        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];

        int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Point start = new Point(arr[0], arr[1]);
        Point end = new Point(arr[2], arr[3]);

        Queue<Point> q = new LinkedList<>();
        q.add(start);

        int result=0;

        while(!q.isEmpty()) {

            if(map[end.r][end.c]!=0) {
                result = map[end.r][end.c];
                break;
            }

            Point temp = q.poll();

            for(int i=0;i<6;i++) {
                int nextR = temp.r+dr[i];
                int nextC = temp.c+dc[i];
                if(nextR>=0 && nextC>=0 && nextR<N && nextC<N && map[nextR][nextC]==0) {
                    Point next = new Point(nextR, nextC);
                    map[nextR][nextC] = map[temp.r][temp.c]+1;
                    q.add(next);
                }
            }
        }

        if(result==0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }
}

class Point {
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

    int r;
    int c;
}