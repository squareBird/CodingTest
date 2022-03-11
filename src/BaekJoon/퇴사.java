//package BaekJoon;
//
//import java.util.Scanner;
//
//public class 퇴사 {
//
//    private static int N;
//    private static Consult[] consults;
//    private static boolean[] visit;
//    private static int MAX = 0;
//
//    public static void main(String[] args) {
//
//        Scanner scan = new Scanner(System.in);
//        N = scan.nextInt();
//        consults = new Consult[N];
//
//        for(int i=0;i<N;i++) {
//            consults[i]= new Consult(scan.nextInt(), scan.nextInt());
//        }
//
//        for(Consult c : consults) {
//            System.out.println(c.toString());
//        }
//
//    }
//    // index 현재 날짜
//    // sum = 받는 금액
//    static void dfs(int index, int sum) {
//
//        if(index+consults[index].day>N-1) {
//            if(sum>MAX) {
//                MAX = sum;
//            }
//            return;
//        }
//
//        // 1. 처음에 0,0으로 왔음
//        // 2. 1일차 3, 10임
//        // 3. 0,1,2 배열 visited true로 변경 후 sum에 10을 더함
//        // 4. 4일차꺼부터 다시 시작
//        // 5. 4일차 1,20
//        // 6. 4일차 true로 바꾸고 sum에 20 더함
//        // 7. 5일차 넣음
//
//        for(int i=index;i<N;i++) {
//            for(int j=i;j<consults[i].day;i++) {
//                visit[j]=true;
//            }
//            dfs(j, sum+consults[j].price);
//
//        }
//    }
//}
//
//class Consult {
//    int day;
//    int price;
//
//    public Consult(int day, int price) {
//        this.day = day;
//        this.price = price;
//    }
//
//    @Override
//    public String toString() {
//
//        return this.day + " " + this.price;
//    }
//}
