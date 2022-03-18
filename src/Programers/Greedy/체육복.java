package Programers.Greedy;

import java.util.Arrays;

public class 체육복 {

    // 전체 학생 수
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        answer = n-lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌이 있는데 도난당한 경우
        // 자기자신이 써야함
        for(int i=0;i<reserve.length;i++) {
            for(int j=0;j<lost.length;j++) {
                if(reserve[i]==lost[j]) {
                    answer++;
                    reserve[i]=-1;
                    lost[j]=-1;
                }
            }
        }

        // 빌려줄 수 있는 경우
        for(int i=0;i<reserve.length;i++) {
            for(int j=0;j<lost.length;j++) {
                // 아직 빌려주지 않았고, 아직 빌리지 않았을 경우
                if(reserve[i]!=-1 && lost[j]!=-1) {
                    // 여유가 있는애 - 없는애의 값의 차이가 1이면
                    if(reserve[i]-lost[j]==1 || reserve[i]- lost[j]==-1) {
                        answer++;
                        // 빌려줌
                        reserve[i]=-1;
                        lost[j]=-1;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {


    }
}
