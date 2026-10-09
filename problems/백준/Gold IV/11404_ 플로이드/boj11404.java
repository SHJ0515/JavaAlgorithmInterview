import java.io.*;
import java.util.*;

/*
boj11404 플로이드
- n개의 도시, 한 도시에서 다른 도시에 가는 m개의 버스
- 도시 A -> B로 가는데 필요한 비용의 최솟값 구하기 (모든 도시에 대해서)
 */

public class boj11404 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] minCostTable;
    static int n, m;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        minCostTable = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    minCostTable[i][j] = 0;   //자기자신 -> 비용 0
                }
                else {
                    minCostTable[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            //노선들 중 최솟값 선택
            minCostTable[from - 1][to - 1] = Math.min(minCostTable[from - 1][to - 1], cost);
        }

        findMinCost();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(minCostTable[i][j]).append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static void findMinCost() {
        // k : 거쳐가는 노드, i : 출발노드, k : 도착노드
        // i -> j를 가는동안 i -> k -> j 가 있다면 둘이 값 비교

        /*
         * 경유 정점 k를 가장 바깥 반복문에 둔다.
         *
         * 각 k 단계에서 모든 시작점 i와 도착점 j를 검사하여,
         * 1~k번 정점을 경유할 수 있을 때의 최단 거리를 완성한다.
         *
         * 이렇게 해야 이전 단계에서 계산한 최단 거리를 활용하여
         * 여러 정점을 경유하는 최단 경로도 올바르게 계산할 수 있다.
         */

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //경로 x
                    if (minCostTable[i][k] == Integer.MAX_VALUE || minCostTable[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }

                    int current = minCostTable[i][j];
                    int tmp = minCostTable[i][k] + minCostTable[k][j];
                    minCostTable[i][j] = Math.min(current, tmp);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (minCostTable[i][j] == Integer.MAX_VALUE){
                    minCostTable[i][j] = 0;
                }
            }
        }
    }
}

/*
플로이드 알고리즘 : 모든 정점 쌍 사이의 최단 거리를 구하는 알고리즘

[from][to]의 비용 은
-> [from][to] 와 ([from][tmp] + [tmp][to]) 의 거리중 더 작은걸 고르기

 */