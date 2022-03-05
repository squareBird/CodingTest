package Programers.Hash;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumber {

    public static void main(String[] args) {

        PhoneNumber p = new PhoneNumber();
        String[] phone_book = {"119", "97674223", "1195524421"};

    }

    public boolean solution(String[] phone_book) {

        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i< phone_book.length;i++) {
            map.put(phone_book[i], i);
        }

        for(int i=0;i<phone_book.length;i++) {
            for(int j=0;j<phone_book[i].length();j++) {
                // 왜 substring을 했을까?
                if(map.containsKey(phone_book[i].substring(0,j))) {
                    return false;
                }

            }
        }

        return true;

    }






//    public boolean solution(String[] phone_book) {
//
//        for(int i=0;i<phone_book.length-1;i++) {
//            for(int j=i+1;j<phone_book.length;j++) {
//                if(phone_book[i].startsWith(phone_book[j])) return false;
//                if(phone_book[j].startsWith(phone_book[i])) return false;
//            }
//        }
//
//        return true;
//
//    }

}
