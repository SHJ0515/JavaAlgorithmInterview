import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int K = Integer.parseInt(split[2]);

        int[][] map = new int[N][M];
        int[][] visited = new int[N][M];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    map[k][j] = 1;
                }
            }
        }

        List<Integer> result = bfs(map, visited);
        result.sort(null);

        sb.append(result.size()).append('\n');
        for (int size : result) {
            sb.append(size).append(' ');
        }
        System.out.println(sb);
    }

    public static List<Integer> bfs(int[][] map, int[][] visited) {
        int n = map.length;
        int m = map[0].length;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        List<Integer> count = new ArrayList<>();

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (map[i][j] == 0 && visited[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                    int size = 0;

                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];
                        size++;

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                                if (map[nx][ny] == 0 && visited[nx][ny] == 0) {
                                    queue.add(new int[]{nx, ny});
                                    visited[nx][ny] = 1;
                                }
                            }
                        }
                    }
                    count.add(size);
                }
            }
        }
        return count;
    }
}
