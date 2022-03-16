import java.util.Arrays;
import java.util.Iterator;

public class stream {

    public static void main(String[] args) {


        String a = "112341111";
        String[] arr = a.split("");
        int count = 0;

        Iterator it = Arrays.stream(Arrays.stream(arr).filter(s -> Integer.parseInt(s) >= 2).toArray()).iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


}
