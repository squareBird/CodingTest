package 연습;

import java.util.Arrays;
import java.util.Iterator;

public class Stream {

    int x;
    int y;

    public static void main(String[] args) {


//        String a = "112341111";
//        String[] arr = a.split("");
//        int count = 0;
//
//        Iterator it = Arrays.stream(Arrays.stream(arr).filter(s -> Integer.parseInt(s) >= 2).toArray()).iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

        Stream[] s = new Stream[10];
        for(int i=0;i<10;i++) {
            s[i] = new Stream();
            s[i].x=i;
            s[i].y=i;
        }

//        Arrays.stream(s).forEach(st -> System.out.println("st.x+st.y) = " + st.x+st.y));
        // 특정 클래스 안의 특정 값들을 더해서 mapToInt로 리턴가능...
        Arrays.stream(s).mapToInt(value -> value.x+ value.y).forEach(value -> System.out.println("value = " + value));


    }

}
