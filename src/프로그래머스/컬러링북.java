package 프로그래머스;


// [[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]
// 4,5

// 틀렷다...
// 나중에 또 풀어보기

public class 컬러링북 {

    public static void main(String[] args) {
        컬러링북 c = new 컬러링북();
        int[][] pic = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        c.solution(6,4,pic);
    }

    // 상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visit;

    static int numberOfArea = 0;
    static int size = 0;
    static int maxSizeOfOneArea = 0;


    public int[] solution(int m, int n, int[][] picture) {

        visit = new boolean[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(visit[i][j]==false && picture[i][j]!=0) {
                    size=0;
                    numberOfArea++;
                    dfs(i,j,picture[i][j], picture);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }

        System.out.println(numberOfArea);
        System.out.println(maxSizeOfOneArea);

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    void dfs(int x, int y, int number, int[][] picture) {
        visit[x][y]=true;
        size++;

        for(int i=0;i<4;i++) {
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            // 다음 좌표가 맵의 크기를 넘어가지 않고
            if(nextX>=0 && nextY>=0 && nextX<picture.length && nextY<picture[0].length &&
                    // 다음 갈곳에 아직 방문하지 않았고, 값이 현재 점과 같으면
                    visit[nextX][nextY]==false && picture[nextX][nextY]==number) {
                dfs(nextX, nextY, number, picture);
            }

        }
    }

}
