package 팀랩;

public class Fibo {

    static int result[];

    public static void main(String[] args) {

        result = new int[100];

        System.out.println(fibo(10));

    }

    static int fibo(int n) {
        if(n<=1) {
            return n;
        }
        return fibo(n-1)+fibo(n-2)+fibo(n-3);

    }
}
