import java.io.*;

/*
boj 1463 1로 만들기
*/

public class boj1463 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // DP 테이블: D[i] : i를 1로 만들기 위해 필요한 연산 횟수의 최소값
    static int[] D = new int[1000001];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        D[1] = 0;

        for (int i = 2; i <= n; i++) {
            D[i] = D[i - 1] + 1;

            if (i % 2 == 0) {
                D[i] = Math.min(D[i], D[i / 2] + 1);
            }
            if (i % 3 == 0) {
                D[i] = Math.min(D[i], D[i / 3] + 1);
            }
        }
        System.out.println(D[n]);
    }
}

/* BFS
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] visited = new int[1000001];
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        visited[n] = 1;
        bfs();
    }

    public static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{n, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cnt = poll[1];
            if (poll[0] == 1) {
                System.out.println(cnt);
                break;
            }

            if (poll[0] % 3 == 0 && visited[poll[0] / 3] != 1) {
                queue.add(new int[]{poll[0] / 3, cnt + 1});
                visited[poll[0] / 3] = 1;
            }
            if (poll[0] % 2 == 0 && visited[poll[0] / 2] != 1) {
                queue.add(new int[]{poll[0] / 2, cnt + 1});
                visited[poll[0] / 2] = 1;
            }
            if (visited[poll[0] - 1] != 1) {
                queue.add(new int[]{poll[0] - 1, cnt + 1});
                visited[poll[0] - 1] = 1;
            }
        }
    }
}
*/

/*
DP
1. 테이블 정의
2. 점화식 찾기
3. 초기값 정하기
 */