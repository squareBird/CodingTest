package 코테_20220312;

class Coin {

    static int[] coin = {1,5,10,50,100,500};
    static int[] value;
    static boolean[] used = new boolean[6];
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Coin c = new Coin();
        int money = 4578;
        int[] costs = {1, 4, 99, 35, 50, 1000};
        System.out.println(c.solution(money, costs));
    }

    public int solution(int money, int[] costs) {

        value = costs;

        dfs(money,0);

        return MIN;

    }

    static void dfs(int money, int price) {

        System.out.println();

        if(money==0) {
            System.out.println(price + " 끝");
            System.out.println();
            if(price<MIN) {
                MIN=price;
            }
            return;
        }

        for(int i=0;i<6;i++) {
            System.out.println("money = " + money);
            System.out.println("price = " + price);

            if(!used[i]) {
                // coin[i]를 몇개 사용하는지
                int temp = money/coin[i];
                System.out.println("temp  = " + temp + " coin = " + coin[i]);
                // 지금까지 생산하는데 든 비용
                int nextPrice = price + value[i]*temp;
                // 남은 금액
                int nextMoney=money%coin[i];

                used[i]=true;
                dfs(nextMoney, nextPrice);
                used[i]=false;
            }
        }
    }
}