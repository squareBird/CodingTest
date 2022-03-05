package Programers;

class Solution {

    public int[] solution(String[] id_list, String[] report, int k) {

        // 1.

        int[] answer = {};
        return answer;
    }

    public static void main(String args[]) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        Solution s = new Solution();
        System.out.println(s.solution(id_list, report, k));
    }
}

