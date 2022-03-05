//import java.util.ArrayList;
//
//class Nickname {
//
//    public String solution(String new_id) {
//
//        // 소문자로 변환
//        String step1 = new_id.toLowerCase();
//        char[] arr = new_id.toCharArray();
//
//        // 이상한 문자 제거
//        StringBuilder step2 = new StringBuilder();
//
//        for(char c : arr) {
//            if((c>='a' && c<='z') || (c>=0 && c<=9) || c=='-' || c=='_' || c=='.')
//                step2.append(c);
//        }
//
//        // . 두개이상 하나로 치환
//
//        String step3 = step2.toString().replace("..",".");
//        while(step3.contains("..")) {
//            step3.replace("..",".");
//        }
//
//        // 4. 처음이나 끝 마침표 제거
//        String step4;
//        while(step3.startsWith("."))
//
//
//    }
//
//    public static void main(String args[]) {
//
//
//    }
//}