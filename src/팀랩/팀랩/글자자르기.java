package 팀랩;

public class 글자자르기 {

    static String word = "1112222222222";

    public static void main(String args[]) {

        int[] arr = new int[100];

        for(int i=0;i<word.length()-3;i++) {
           arr[Integer.parseInt(word.substring(i,i+3))]++;
           System.out.println(arr[Integer.parseInt(word.substring(i,i+2))]);

        }

        int max = 0;

        for(int i=0;i<arr.length;i++) {
            if(arr[i]>max) max=i;
        }

        System.out.println(max);

    }

}
