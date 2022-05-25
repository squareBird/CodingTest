package Programmers;

import java.util.HashSet;

// 전화번호 목록
// https://programmers.co.kr/learn/courses/30/lessons/42577
// 다른사람 코드 봄...
public class PhoneNumberList {

    public boolean solution(String[] phoneBook) {
        for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                // 예를들어 3개라면
                // i는 0, j는 1부터 시작임
                // phone[0]이 phone[1]로 시작하는지 비교하고 그 반대도 비교함
                // phone[0]이 phone[2]로 시작하는지 비교하고 그 반대도 비교함
                // 그다음에 for문을 빠져나가서 i가 1증가
                // phone[1]이 phone[2]로 시작하는지 비교하고 그 반대도 비교함
                // 이렇게 결국 전체를 비교하게 됨!
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }

    public static void main(String args[]) {

    }

}
