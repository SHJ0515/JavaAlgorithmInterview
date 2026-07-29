import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];   // 높이정보 맵

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }

        int maxCount = 0;
        for (int i = 0; i <= max; i++) {
            int count = bfs(map, i);
            if (count > maxCount) {
                maxCount = count;
            }
        }
        System.out.println(maxCount);
    }

    //안전영역의 개수
    public static int bfs(int[][] map, int rainHeight) {

        int[][] visited = new int[map.length][map[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        //침수 지역 -> 0
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] < rainHeight) {
                    map[i][j] = 0;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != 0 && visited[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                    count++;

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
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}

/*
높이정보,
비 왔을때 안전영역 -> 특정 높이 이하는 다 잠김
안전영역의 최대 개수 구하기

 */