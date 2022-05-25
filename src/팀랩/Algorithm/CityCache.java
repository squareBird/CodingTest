import java.util.*;

public class CityCache {

    public int solution(int cacheSize, String[] cities) {

        if(cacheSize == 0) return cities.length * 5;

        int answer = 0;

        Queue<String> q = new LinkedList<>();

        for(String s : cities) {
            // 대소문자 통일을위함
            String city = s.toUpperCase();

            // 큐에서 s가 지워지면(cache hit)
            if(q.remove(city)) {
                q.add(city);
                answer++;
            } else {
                // 큐에 해당 도시가 존재하지 않을 경우
                // 큐 사이즈가 cacheSize 일 때(꽉 찼을때)
                // 큐 사이즈가 캐시 사이즈일때 하나를 빼주기때문에 초과할일 없음
                if(q.size()==cacheSize) {
                    // 들어간지 가장 오래된걸 뺌(FIFO)
                    q.poll();
                }

                q.add(city);
                answer+=5;
            }
        }

        return answer;
    }


    public static void main(String args[]) {

        CityCache c = new CityCache();
        c.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"});

    }



}
