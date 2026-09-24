
import java.io.*;
import java.util.*;

/*
boj11724 연결요소의 개수
 */

public class boj11724 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        graph = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        bfs();
    }

    public static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (visited[i]){
                continue;
            }

            queue.add(i);
            visited[i] = true;
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();

                for (Integer integer : graph[poll]) {
                    if (!visited[integer]) {
                        queue.add(integer);
                        visited[integer] = true;
                    }
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
