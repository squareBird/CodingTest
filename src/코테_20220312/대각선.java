package 코테_20220312;

public class 대각선 {

    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int width, int height, int[][] diagonals) {

        map = new int[width][height];

        for(int[] dia : diagonals) {
            map[width-dia[0]][0+dia[1]-1] = 1;
        }

        for(int[] x : map) {
            for(int y : x) {
                System.out.print(y);
            }
            System.out.println();
        }

        /**
         * 대각선의 위치는
         * (width,0)을 기준으로 (width-diagonals[1], 0+diagonals[1])을 이은 위치
         */




        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        대각선 a = new 대각선();
        int width = 51;
        int height = 37;
        int[][] diagonals = {{17,19}};
        a.solution(width,height,diagonals);
    }


}
