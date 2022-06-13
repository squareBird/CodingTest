package 프로그래머스.카카오문제.Level1;


import java.util.Arrays;
import java.util.stream.Stream;

public class Lotto {

    public static void main(String[] args) {

        Lotto l = new Lotto();
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        l.solution(lottos, win_nums);

    }

    public int[] solution(int[] lottos, int[] win_nums) {

        /**
         * 1. 0의 갯수 구함
         * 2. 2개의 배열을 합침
         * 3. 중복을 제거
         * 4. 줄어든 길이를 2로 나눈 값이 최소값
         * 5. 줄어든 길이를 2로 나눈 값에 0의 갯수를 더한 것이 최대값
         */

        int[] answer = {};

        int[] lotto = Arrays.stream(lottos).sorted()
                .filter(x -> x != 0)
                .toArray();

        int zeroCount = lottos.length - lotto.length;
        int before = lotto.length+6;

        Integer[] integers = Stream.of(lotto, win_nums).distinct().toArray(Integer[]::new);

        int after = integers.length;

        answer[0] = (before-after)/2;
        answer[1] = (before-after)/2+zeroCount;

        return answer;
    }

}
