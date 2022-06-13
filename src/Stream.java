import java.util.Arrays;
import java.util.function.BinaryOperator;

public class Stream {

    public static void main(String[] args) {

    }

    void 람다식() {
        // 람다식
        BinaryOperator<Integer> b = (x, y) -> x+y;
        Integer c = 1;
        Integer d = 2;
        System.out.println(b.apply(c,d));

    }

    void 특정_문자_제거() {
        int[] a = {1,2,0,5};

        // 이거 빼기
        int[] ints = Arrays.stream(a)
                .filter(x -> x != 0)
                .toArray();

        for(int i : ints) {
            System.out.println(i);
        }

    }
}
