
import java.io.*;
import java.util.*;

/*
boj1260 DFS와 BFS
- 그래프를 DFS와 BFS로 탐색한 결과를 출력
- 방문 가능 vertex가 여러개일 경우 번호가 작은 순으로 방문
- vertex는 1 ~ n
 */

public class boj1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n, m, start;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        for (int i = 1; i <= n; i++) {
            graph.get(i).sort(Comparator.naturalOrder());
        }

        dfs(start);
        System.out.println(sb);
        sb.setLength(0);
        reset();
        bfs();
    }

    public static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            sb.append(poll).append(' ');

            List<Integer> list = graph.get(poll);
            for (Integer i : list) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println(sb);
        reset();
    }

    public static void dfs(int current) {
        visited[current] = true;
        sb.append(current).append(' ');

        List<Integer> list = graph.get(current);
        for (Integer i : list) {
            if (!visited[i]){
                dfs(i);
            }
        }
    }

    public static void reset() {
        for (int i = 0; i <= n; i++) {
            visited[i] = false;
        }
    }
}
