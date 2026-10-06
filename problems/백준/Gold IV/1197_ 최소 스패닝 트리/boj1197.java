import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
boj1197 최소 스패닝 트리
- 그래프가 주어졌을 때 MST의 가중치값을 구하기
 */

public class boj1197 {
    static class Edge {
        int from;
        int to;
        int cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int[] parent;

    static int find(int vertex) {
        if (parent[vertex] == vertex) {
            return vertex;
        }
        parent[vertex] = find(parent[vertex]);
        return parent[vertex];
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return false;
        }

        parent[rootB] = rootA;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, cost));
        }

        edges.sort(Comparator.comparingInt(edge -> edge.cost));

        parent = new int[vertexCount + 1];
        for (int i = 1; i <= vertexCount; i++) {
            parent[i] = i;
        }

        long totalCost = 0;
        int selectedEdgeCount = 0;

        for (Edge edge : edges) {
            if (union(edge.from, edge.to)) {
                totalCost += edge.cost;
                selectedEdgeCount++;

                if (selectedEdgeCount == vertexCount - 1) {
                    break;
                }
            }
        }

        System.out.println(totalCost);
    }
}

/*
크루스칼 알고리즘
1. 간선을 크기의 오름차순으로 정렬하고 제일 낮은 비용의 간선을 선택
2. 현재 선택한 간선이 정점 u, v를 연결하는 간선이라고 할 때 만약 u와 v가 같은 그룹이라면 아무 것도 하지 않고 넘어감, u와 v가 다른 그룹이라면 같은 그룹으로 만들고 현재 선택한 간선을 최소 신장 트리에 추가
3. 최소 신장 트리에 V-1개의 간선을 추가시켰다면 과정을 종료, 그렇지 않다면 그 다음으로 비용이 작은 간선을 선택한 후 2번 과정을 반복

프림 알고리즘
1. 임의의 정점을 선택해 최소 신장 트리에 추가
2. 최소 신장 트리에 포함된 정점과 최소 신장 트리에 포함되지 않은 정점을 연결하는 간선 중 비용이 가장 작은 것을 최소 신장 트리에 추가
3. 최소 신장 트리에 V-1개의 간선이 추가될 때 까지 2번 과정을 반복
 */