import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][] visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        bfs(map, visited);
    }

    public static void bfs(int[][] map, int[][] visited) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int num = 0;
        List<Integer> list = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                if (map[i][j] == 1 && visited[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                    num++;
                    int count = 1;

                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[i].length) {
                                if (map[nx][ny] != 0 && visited[nx][ny] == 0) {
                                    queue.add(new int[]{nx, ny});
                                    visited[nx][ny] = 1;
                                    count++;
                                }
                            }
                        }
                    }
                    list.add(count);
                }
            }
        }
        list.sort(null);

        System.out.println(num);
        for (int a : list) {
            System.out.println(a);
        }
    }
}