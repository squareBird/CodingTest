package 프로그래머스;

public class TargetNumber {

    static int result = 0;

    public int solution(int[] numbers, int target) {

        dfs(numbers, target, 0, 0);

        return result;
    }

    void dfs(int[] numbers, int target, int now, int index) {

        // 현재 값이 타겟과 같고 숫자를 전부 사용했으면 result++
        if(now==target && index==numbers.length) {
            result++;
        }
        if(index==numbers.length) return;

        for(int i=0;i<2;i++) {
            dfs(numbers, target, now+numbers[index], index+1);
            dfs(numbers, target, now-numbers[index], index+1);
        }

    }

    class Solution {

        static int answer = 0;

        static void dfs(int[] numbers, int target, int value, int count) {

            if(count==numbers.length) {
                if(value==target) answer++;
                return;
            }

            dfs(numbers, target, value+numbers[count], count+1);
            dfs(numbers, target, value-numbers[count], count+1);
        }

        public int solution(int[] numbers, int target) {

            dfs(numbers, target, 0, 0);
            return answer;
        }
    }

}
