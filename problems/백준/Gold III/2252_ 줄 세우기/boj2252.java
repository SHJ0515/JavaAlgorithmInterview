import java.io.*;
import java.util.*;

/*
boj2252 줄 세우기
- N명의 학생을 키 순으로 줄세우기
- 두 학생의 키를 비교, 일부학생들만 비교
- M번 비교 -> a b 일 경우 a가 b의 앞에 선다
 */

public class boj2252 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] indegree = new int[n + 1];
        List<List<Integer>> relations = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            relations.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            indegree[back] += 1;
            relations.get(front).add(back);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            sb.append(poll).append(' ');

            List<Integer> list = relations.get(poll);
            for (Integer i : list) {
                indegree[i] -= 1;
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
        System.out.println(sb);
    }
}

/*
위상정렬
- 방향 그래프에서 간선으로 주어진 정점 간 선후관계를 위배하지 않도록 나열하는 정렬
- 싸이클 존재시 올바른 위상정렬 불가능, 모순 발생
- indegree가 0인 vertex 부터 앞에 옴
- 첫 정점이 등장했으면 해당 정점이 가리키는 엣지들을 모두 제거
- 다음 정점 검사 indegree 0이라면 정렬 추가, 추가 된 정점으로부터 또 가리키는 엣지 모두 제거
- 해당 과정을 모든 정점을 넣을때까지 반복

실제 구현
- 미리 indegree 값을 저장했다. 뻗어나가는 정점들의 indegree 들을 -1
- indegree가 0인 정점 목록을 큐로 관리
1. 맨 처음 모든 간선을 읽으며 indegree 테이블 채우기
2. indegree가 0인 정점들을 모두 큐에 add
3. 큐에서 정점을 꺼내어 위상정렬 결과에 추가
4. 해당 정점으로부터 연결된 모든 정점의 indegree를 -1, 이때 indegree 0 인 정점 발생시 큐에 add
5. 큐가 빌때까지 3,4 반복
 */