import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            bfs();
        }
    }

    public static void bfs() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        int[][] humanVisited = new int[n][m];
        int[][] fireVisited = new int[n][m];
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        Queue<int[]> humanQueue = new ArrayDeque<>();
        Queue<int[]> fireQueue = new ArrayDeque<>();

        // # : 벽, . : 빈공간, @ : 시작위치, * : 불 위치
        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = charArray[j];

                if (charArray[j] == '@') {
                    humanQueue.add(new int[]{i, j});
                    humanVisited[i][j] = 1;
                }
                if (charArray[j] == '*') {
                    fireQueue.add(new int[]{i, j});
                    fireVisited[i][j] = 1;
                }
            }
        }

        //fireBfs
        while (!fireQueue.isEmpty()) {
            int[] poll = fireQueue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 맵 내부 and 이동 가능한 공간이면서 미방문일 때
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (fireVisited[nx][ny] == 0 && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
                        fireQueue.add(new int[]{nx, ny});
                        fireVisited[nx][ny] = fireVisited[x][y] + 1;
                    }
                }
            }
        }

        //humanBfs
        while (!humanQueue.isEmpty()) {
            int[] poll = humanQueue.poll();
            int x = poll[0];
            int y = poll[1];

            // 외곽 체크, 외곽이라면 탈출 성공
            if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
                System.out.println(humanVisited[x][y]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵 내부
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 이동 가능한 공간 and 미방문
                    if (map[nx][ny] == '.' && humanVisited[nx][ny] == 0) {
                        //불 미방문 or 불보다 빠름
                        if(fireVisited[nx][ny] == 0 || humanVisited[x][y] + 1 < fireVisited[nx][ny]){
                            humanQueue.add(new int[]{nx, ny});
                            humanVisited[nx][ny] = humanVisited[x][y] + 1;
                        }
                    }
                }
            }
        }

        //humanBfs에서 탈출 실패시 무조건 불가능
        System.out.println("IMPOSSIBLE");
    }
}
