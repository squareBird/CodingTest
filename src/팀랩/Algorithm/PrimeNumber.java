package Algorithm;

public class PrimeNumber {

    static int N = 1000;

    public static void main(String args[]) {

        boolean[] arr = new boolean[N+1];
        arr[0]=arr[1]=true;

        // 왜 i*i 즉 i제곱부터 할까?
        // 예를 들면 5*2는 할필요가 없음
        // 왜냐면 2에 대한 배수를 지울때 2*5가 함께 지워졌기 때문
        // 이처럼 5까지 가는동안 3,4에 대해서도 진행했기 때문에
        // 5*3도 3*5의 형태로 이미 계산되었고
        // 5*4도 2*2*5의 형태로 이미 계산되었음
        // 따라서 i 제곱부터 하면됨!
        for(int i=2; i*i<=N; i++) {
            if(!arr[i]) {

                // j는 i의 배수부터 시작임 i를 더해도 똑같이 i의 배수임
                // i=2라고 가정 j=1000까지
                // j=4부터 6.8.10.12
                // j=25 30.35.45.50.55.60
                // j=36 36.42.48.54
                for(int j=i*i; j<=N; j+=i) {
                    arr[j] = true;
                }

            }
        }

        for(int i=0;i<N;i++) {
            if(arr[i]==false)
                System.out.println(i);
        }

    }

}
