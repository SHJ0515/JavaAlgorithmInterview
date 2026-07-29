import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[1]);
        int m = Integer.parseInt(split[0]);
        int h = Integer.parseInt(split[2]);
        int[][][] map = new int[n][m][h];             // 1 : 익은 토마토, 0 : 안익은 토마토, -1 : 토마토 없음
        int[][][] visited = new int[n][m][h];

        int empty = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        //토마토 세팅
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int cur = Integer.parseInt(st.nextToken());
                    map[j][k][i] = cur;

                    // 익어있는 토마토 바로 큐에 넣기
                    if (cur == 1) {
                        queue.add(new int[]{j, k, i});
                        visited[j][k][i] = 1;
                    }
                    else if (cur == -1) {
                        empty++;
                    }
                }
            }
        }

        if (isRiped(queue, n, m, h, empty)) {
            System.out.println(0);
        }
        else {
            int day = bfs(queue, map, visited, n, m, h);

            if (isImpossible(map, n, m, h)) {
                System.out.println(-1);
            }
            else {
                System.out.println(day - 1);
            }
        }
    }

    public static boolean isRiped(Queue<int[]> q, int n, int m, int h, int empty) {
        if (n * m * h == q.size() + empty) {
            return true;
        }
        return false;
    }

    public static boolean isImpossible(int[][][] map, int n, int m, int h) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[j][k][i] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int bfs(Queue<int[]> queue, int[][][] map, int[][][] visited, int n, int m, int h) {
        int day = 0;
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int[] dz = new int[]{1, -1};      //위 아래는 dx dy와 따로 +-1

        //내 주변이 안익은 토마토인경우 큐에 삽입 하면서 map에 익은토마토 1로 바꾸기
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            day = visited[poll[0]][poll[1]][poll[2]];

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                int nz = poll[2];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny][nz] == 0) {
                        queue.add(new int[]{nx, ny, nz});
                        map[nx][ny][nz] = 1;
                        visited[nx][ny][nz] = day + 1;
                    }
                }
            }

            for (int i = 0; i < 2; i++) {
                int nx = poll[0];
                int ny = poll[1];
                int nz = poll[2] + dz[i];

                if (nz >= 0 && nz < h) {
                    if (map[nx][ny][nz] == 0) {
                        queue.add(new int[]{nx, ny, nz});
                        map[nx][ny][nz] = 1;
                        visited[nx][ny][nz] = day + 1;
                    }
                }
            }
        }
        return day;
    }

}