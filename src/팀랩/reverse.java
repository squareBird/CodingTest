package 팀랩;

public class reverse {

    public static void main(String[] args) {

        int n = 1;
        int result = 0;

        while(true) {

            if(result>=10) {
                System.out.println(n);
                break;
            }
            result += 1/n;
            n++;

        }

    }





}
