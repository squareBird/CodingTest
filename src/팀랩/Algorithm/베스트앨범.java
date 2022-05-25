import java.util.*;

public class 베스트앨범 {

    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> hm = new HashMap<>();

        for (int i=0;i<genres.length;i++) {
            hm.put(genres[i], hm.getOrDefault(genres[i],0)+plays[i]);
        }

        String[][] arr = new String[hm.size()][2];

        int k=0;

        for(String s : hm.keySet()) {
            arr[k][0]=s;
            arr[k][1]=hm.get(s).toString();
        }

        Comparator<String[]> comp = new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o2[1])-Integer.parseInt(o1[1]);
            }
        };

        Arrays.sort(arr,comp);

        for(int j=0;j<arr.length;j++) {
            System.out.println(arr[j][0] +" " +arr[j][1]);
        }








//
//        // 해쉬맵 <장르명, 해쉬맵 <번호, 재생횟수>
//        HashMap<String, HashMap<Integer, Integer>> hm = new HashMap<>();
//
//        // 해당 장르가 있으면
//        for(int i=0;i<genres.length;i++) {
//            // 고유번호랑 재생횟수 넣음
//            if(hm.keySet().contains(genres[i])) {
//                hm.get(genres[i]).put(i, plays[i]);
//            } else { // 없을경우
//                hm.put(genres[i], new HashMap<>(i, plays[i]));
//            }
//        }



        int[] answer = {};
        return answer;













    }
}
