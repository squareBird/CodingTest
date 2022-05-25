import java.util.HashMap;

public class SpyCloth {

    public int solution(String[][] clothes) {

        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();

        for(int i=0;i<clothes.length;i++) {
            String item = clothes[i][0];

            if(!hm.keySet().contains(item)) {
                hm.put(item,1);
            } else {
                hm.put(item, hm.get(item)+1);
            }
        }

        for(String s : hm.keySet()) {
            // 모자가 3개, 티셔츠가 3개일 경우
            // 모자를 입는 경우의 수는 4개 = 3개중에 하나 입거나 안입거나
            // 티셔츠를 입는 경우의 수도 4개 = 3개중에 하나 입거나 안입거나
            answer *= hm.get(s)+1;
        }
        // 아예 안입을순 없으므로 아예 안입는 경우 하나 뺌
        return answer-1;

    }

    public static void main(String args[]) {

    }
}
