import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        while (true) {
            String[] inputs = br.readLine().split(" ");
            int L = Integer.parseInt(inputs[0]);
            int R = Integer.parseInt(inputs[1]); // N
            int C = Integer.parseInt(inputs[2]); // M

            if (isFinish(L, R, C)) {
                break;
            }

            char[][][] map = new char[L][R][C];
            int[][][] visited = new int[L][R][C];

            setMap(map, L, R, C);
            bfs(map, visited, L, R, C);
        }
    }

    public static boolean isFinish(int L, int R, int C) {
        if (L == 0 && R == 0 && C == 0) {
            return true;
        }
        return false;
    }

    public static void setMap(char[][][] map, int L, int R, int C) throws IOException {

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                char[] charArray = br.readLine().toCharArray();
                for (int k = 0; k < C; k++) {
                    map[i][j][k] = charArray[k];
                }
            }
            br.readLine();
        }
    }

    public static void bfs(char[][][] map, int[][][] visited, int L, int R, int C) {
        int[] dx = {1, 0, -1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (map[i][j][k] == 'S') {
                        visited[i][j][k] = 1;
                        queue.add(new int[]{i, j, k, 0});

                        while (!queue.isEmpty()) {
                            int[] poll = queue.poll();

                            int z = poll[0];
                            int x = poll[1];
                            int y = poll[2];
                            int time = poll[3];

                            if (map[z][x][y] == 'E') {
                                System.out.println("Escaped in " + time + " minute(s).");
                                return;
                            }

                            for (int l = 0; l < 6; l++) {
                                int nz = z + dz[l];
                                int nx = x + dx[l];
                                int ny = y + dy[l];

                                if (nz >= 0 && nz < L && nx >= 0 && nx < R && ny >= 0 && ny < C) {
                                    if (visited[nz][nx][ny] == 0 &&
                                            (map[nz][nx][ny] == '.' || map[nz][nx][ny] == 'E')) {
                                        queue.add(new int[]{nz, nx, ny, time + 1});
                                        visited[nz][nx][ny] = 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Trapped!");
        return;
    }
}
