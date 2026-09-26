
import java.io.*;
import java.util.*;

/*
boj11725 트리의 부모 찾기
 */

public class boj11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static StringTokenizer st;
    static int n;

    static List<List<Integer>> graph = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        parent = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        bfs();
        for (int i = 2; i <= n ; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void bfs(){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        parent[1] = -1;

        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            List<Integer> list = graph.get(poll);
            for (Integer i : list) {
                if (parent[i] != 0){
                    continue;
                }
                parent[i] = poll;
                queue.add(i);
            }
        }
    }

    public static void dfs(int cur) {
        List<Integer> list = graph.get(cur);
        for (Integer i : list) {
            if (parent[i] != 0){
                continue;
            }
            parent[i] = cur;
            dfs(i);
        }
    }
}