package Programers.Greedy;

/////// ?????????

public class 조이스틱 {

    public static void main(String[] args) {
        System.out.println("solution = " + solution("JAN"));
    }

    public static int solution(String name) {
        char[] arr = name.toCharArray();
        // 몇번 움직였는지
        int count = 0;
        int move = name.length()-1;
        // 위아래로 움직인 갯수
        for(int i=0;i<arr.length;i++) {
            int temp=change(arr[i]);
            count+=temp;

            // 왼쪽 오른쪽으로 움직인 갯수
            int nextIndex = i+1;
            while(nextIndex< arr.length && arr[nextIndex] == 'A') {
                nextIndex++;
            }

            move = Math.min(move, (i*2)+ arr.length-nextIndex);
        }



        // 마지막껀 한번 더 이동 안해도 되므로
        return count+move;

    }

    static int change(char kwd) {
        // a가 더 가까울경우
        int a = kwd-'A';
        // z가 더 가까울경우
        int z = 'Z'-kwd+1;

        if(a<z) {
            return a;
        } else {
            return z;
        }
    }
}
