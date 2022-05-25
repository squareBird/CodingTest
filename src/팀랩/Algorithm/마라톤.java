import java.util.HashMap;

public class 마라톤 {

    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> hs = new HashMap<>();

        for(String s : participant) {
            hs.put(s, hs.getOrDefault(s, 0)+1);
        }

        for(String s : completion) {
            if(hs.get(s)==1) {
                hs.remove(s);
            } else {
                hs.put(s, hs.get(s)-1);
            }
        }

        for(String s : hs.keySet()) {
            if(hs.get(s)==1) return s;
        }

        return null;
    }

}
