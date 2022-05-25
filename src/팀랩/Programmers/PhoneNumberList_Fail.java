package Programmers;

// 전화번호 목록
// https://programmers.co.kr/learn/courses/30/lessons/42577
// 효율성테스트 실패
public class PhoneNumberList_Fail {

    boolean result = true;

    public boolean solution(String[] phone_book) {


        for(int i=0;i<phone_book.length;i++) {
            if(result==false) return false;
            check(i,phone_book);
        }

        return true;
    }

    void check(int index, String[] phoneNum) {

        if(result==false) {
            return;
        }

        for(int i=0;i<phoneNum.length;i++) {
            if(result==false) return;

            if(i!=index) {
                if(phoneNum[i].startsWith(phoneNum[index])) result=false;
            }

        }


    }

    public static void main(String args[]) {

    }

}
