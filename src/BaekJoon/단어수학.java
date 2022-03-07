package BaekJoon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class 단어수학 {

/*
    이 문제의 정답은 'max'값을 찾는것이다. 따라서 높은 자릿수에 높은 값(9~0) 을 부여하면 된다.

    GCF는 총 3자리이다. 따라서 100부터 시작한다.
    100G, 10C, 1F

    ACDEB는 총 5자리이다. 따라서 10000부터 시작한다.
    10000A, 1000C, 100D, 10E, 1B

    GCF의 값과 ACDEB의 값을 더해보자.
    10000A, 1B, 1010C, 100D, 10E, 1F, 100G 이 나오게 된다.

    나온 값을 26개의 int형 배열을 생성하여 넣어준후, 정렬한다. (26개를 생성한 이유는 A-Z가 총 26개이기 때문이다.)
    높은값부터 9~0씩 곱하면 답을 구해낼 수 있다.
*/

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        String[] arr = new String[n];
        for(int i=0;i<n;i++) {
            // 알파벳들이 나열된 값
            arr[i] = scan.next();
        }

        // 알파벳이 어느정도 들어있는지 입력하는 값
        int[] alpha = new int[26];

        for(int i=0;i<n;i++) {
            // 알파벳들이 나열된 문자열의 길이를 이용해서 100G, 10F와 같은 식으로 알파벳들이 몇의 자리에 있는지 찾기 위한 temp변수
            int temp = (int)Math.pow(10, arr[i].length()-1);

            // 알파벳이 나열된 문자열에서(arr[i]) 가장 앞에있는 것부터(0부터) (int)arr[i].charAt(j)-65를 이용해 1000, 100, 10과 같은 순서로 값을 입력
            for(int j=0;j<arr[i].length();j++) {
                alpha[(int)arr[i].charAt(j)-65]+=temp;
                // 1000을 입력했으면 다음껀 100, 10 이순서로 가야하니 10으로 나누어 줌
                temp /=10;
            }
        }

        Arrays.sort(alpha); // 이제 10000, 1010, 200 등 각 알파벳들이 몇을 가지고 있는지 들어가 있을것이고 이를 정렬한 뒤 9~0까지 순서대로 곱하면 됨

        int num = 9;
        int result = 0;

        for(int i=alpha.length-1;i>=0;i--) {
            if(alpha[i]==0) {
                break;
            }
            result+=alpha[i]*num;
            num--;
        }

        System.out.println(result);

    }
}
