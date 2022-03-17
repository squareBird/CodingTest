//package BaekJoon;
//
//iport java.util.*;
//
//public class DFSBFS {
//
//    private static int N;
//    private static int M;
//    private static int start;
//    private static boolean[] visit;
//    private static List<Integer>[] list;
//    private static List<String> dfsResult;
//
//    public static void main(String[] args) {
//
//        Scanner scan = new Scanner(System.in);
//
//        dfsResult = new ArrayList<>();
//
//        N = scan.nextInt();
//        M = scan.nextInt();
//        start = scan.nextInt();
//        visit = new boolean[N + 1];
//
//        list = new ArrayList[N + 1];
//
//        for (int i = 0; i <= N; i++) {
//            list[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < M; i++) {
//            int temp1 = scan.nextInt();
//            int temp2 = scan.nextInt();
//            list[temp1].add(temp2);
//            list[temp2].add(temp1);
//        }
//
//        visit[0]=true;
//        dfs(start, start + "");
//        System.out.println(dfsResult.get(0));
//        visit = new boolean[N+1];
//
//
//        bfs();
//
//
//    }
//
//    private static void dfs(int start, String word) {
//
////        System.out.println(start);
////        System.out.println(word);
//        visit[start] = true;
//
//        // 모든 노드를 방문했으면 return
//        if (check()) {
//            dfsResult.add(word);
//            return;
//        }
//
//        for (int i = 1; i <= N; i++) {
//            if (!visit[i] && list[start].contains(i)) {
//                dfs(i, word + " " + i);
//            }
//        }
//    }
//
//    private static void bfs() {
//
//        Queue<Integer> queue = new LinkedList<>();
//        String result = "";
//        visit[start] = true;
//        queue.offer(start);
//
//        while (!queue.isEmpty()) {
//            int temp = queue.poll();
//            result = result + temp + " ";
//            for (int i = 1; i <= N; i++) {
//                if (!visit[i] && list[temp].contains(i)) {
//                    visit[i] = true;
//                    queue.add(i);
//                }
//
//            }
//        }
//        System.out.println(result);
//
//    }
//
//    private static boolean check() {
//        for (boolean b : visit) {
//            if (!b) return false;
//        }
//        return true;
//    }
//}
