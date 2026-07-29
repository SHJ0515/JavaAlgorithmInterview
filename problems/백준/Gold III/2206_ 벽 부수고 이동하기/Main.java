import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int n;
    static int m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        // 원본 맵 입력
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        int[][][] visited = new int[n][m][2]; //[][][0] : 벽 안부신 상태 , [][][1] : 벽 부신 상태

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0, 1});      // n, m, broken, dist
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int broken = poll[2];
            int dist = poll[3];

            if (x == n - 1 && y == m - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 0 && visited[nx][ny][broken] == 0) {
                        queue.add(new int[]{nx, ny, broken, dist + 1});
                        visited[nx][ny][broken] = 1;
                    }
                    else if (map[nx][ny] == 1) {       //벽 만남
                        if (broken == 0) {             //아직 벽 안부순 상태라면 벽 부수고 해당위치 이동
                            queue.add(new int[]{nx, ny, 1, dist + 1});
                            visited[nx][ny][1] = 1;
                        }
                    }
                }
            }
        }
        // 최단거리 못찾은 경우
        return -1;
    }
}





/*
맵 : N X M
이동 가능 : 0 / 이동 불가 벽 : 1
이동 도중에 한번 벽 부수기 가능

최단거리 찾기
0 1 0 0
1 1 1 0
1 0 0 0
0 0 0 0
0 1 1 1
0 0 0 0

불가능 한 경우 : 벽을 최소 2번 깨야할 때

1. 실행 도중 진행 불가능 시 벽 한번 깨기

벽을 안깨도 갈수 있지만 벽을 깨면 최단거리가 줄어드는 경우?

0000
1110
0000
0111
0000

같은 경우 (1,1) 에서 (N,M) 으로 갈때 벽 한번 파괴시 거리 줄어듬

맵 상의 벽을 한개 부수고 시작 -> NM 번 반복문으로 bfs 돌리기?
다 돌리고 나서 최단거리 출력,
최단거리가 한번도 안나온 경우 불가능
-> 이 경우 시간 2초안에 가능?

 */