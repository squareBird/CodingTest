import java.util.Arrays;
import java.util.Comparator;

public class 전화번호목록 {

    public boolean solution(String[] phone_book) {

        for(int i=0;i<phone_book.length-1;i++) {
            for(int j=i+1;j< phone_book.length;j++) {
                if(phone_book[i].startsWith(phone_book[j])) return false;
                if(phone_book[j].startsWith(phone_book[i])) return false;
            }


        }
        return true;

    }

}
