package 일루미;

import java.util.*;

public class Deduplication {

    public static void main(String[] args) {

        String word = "넌 네가 길들인 것에 대해 언제까지나 책임이 있어.\n" +
                "사막이 아름다운 것은 어딘가에 샘을 감추고 있기 때문이야.\n" +
                "만약 오후 4시에 네가 온다면, 나는 3시부터 행복해지기 시작할 거야.\n" +
                "어른들은 누구나 처음엔 어린이였다. 그러나 그것을 기억하는 어른은 별로 없다.\n" +
                "가장 중요한 건 눈에 보이지 않아.\n" +
                "부탁이 있는데요, 양 한 마리만 그려줘.\n" +
                "넌 네가 길들인 것에 대해 언제까지나 책임이 있어.\n" +
                "사막이 아름다운 것은 어딘가에 샘을 감추고 있기 때문이야.\n" +
                "만약 오후 4시에 네가 온다면, 나는 3시부터 행복해지기 시작할 거야.\n" +
                "어른들은 누구나 처음엔 어린이였다. 그러나 그것을 기억하는 어른은 별로 없다.\n" +
                "가장 중요한 건 눈에 보이지 않아.\n" +
                "가장 중요한 건 눈에 보이지 않아.\n" +
                "가장 중요한 건 눈에 보이지 않아.\n" +
                "부탁이 있는데요, 양 한 마리만 그려줘.";

        Deduplication d = new Deduplication();
        d.solution(word);
    }

    public void solution(String words) {

        // 중복을 제거해 저장하기 위한 컬렉션 선언
        Map<String, Integer> map = new HashMap<>();

        int index = -1;

        while (true) {

            // '.'의 위치를 찾음
            // 더 이상 해당 문자열이 없을 경우 -1
            index = words.indexOf('.');

            // index가 -1이면 반복 종료
            if(index==-1) {
                break;
            }

            // 문장의 시작부분 ~ '.'이 있는 부분까지 문자열을 쪼갠 후 Set에 삽입
            // 쪼개진 문자열의 맨앞과 맨 뒤의 '.' 또는 줄바꿈 제거
            String temp = words.substring(0,index+1);
            map.put(temp.trim(), map.getOrDefault(temp.trim(), 0)+1);

            // 기존의 words 문자열을 '.'의 다음 index부터 끝까지 substring
            words = words.substring(index+1);

        }

        for(String key : map.keySet()) {
            System.out.println(map.get(key) + "개" + " : " + key);
        }

    }
}
