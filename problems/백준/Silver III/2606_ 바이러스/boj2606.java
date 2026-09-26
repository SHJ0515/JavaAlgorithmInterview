
import java.io.*;
import java.util.*;

/*
boj2606 바이러스
- 웜 바이러스 전파, 네트워크상 연결되어있는 모든 컴퓨터가 걸림
- 컴퓨터 수, 네트워크 연결정보 주어짐 (노드, 엣지)
- 1번 컴퓨터를 통해 바이러스에 걸리게 되는 컴퓨터의 수 출력

 */

public class boj2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static StringTokenizer st;
    static int v, e;
    static boolean[] visited;

    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[v + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        find();
    }

    public static void find() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        int count = 0;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            visited[poll] = true;

            List<Integer> list = graph.get(poll);
            for (Integer i : list) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        for (boolean b : visited) {
            if (b){
                count++;
            }
        }
        System.out.println(count - 1);
    }

}
