package 프로그래머스;

public class 땅따먹기 {

    public static void main(String[] args) {

    }

    /**
     * 밑으로 내려가면서 값을 더하고 맨 밑줄에서 최대값을 가져오면 된다.
     *
     * @param land
     * @return
     */
    int solution(int[][] land) {

        for (int i=1;i<land.length;i++) {
            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
            land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
            land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
        }

        int max = 0;

        for(int i=0;i<4;i++) {
            max = Math.max(max,land[land.length-1][i]);
        }

        return max;
    }







//        int result = 0;
//
//        for(int i=0;i<land[0].length;i++) {
//            dfs(land[i]);
//        }
//
//        return result;

}
