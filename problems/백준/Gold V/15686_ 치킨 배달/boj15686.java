import java.io.*;
import java.util.*;

/*
백준 치킨배달

크기 NxN
각 칸은 빈칸, 치킨집, 집 셋중 하나 (0 : 빈칸, 1 : 집, 2: 치킨집)
좌표는 (r,c)  1 <= r,c <= N

치킨 거리 : 집과 가장 가까운 치킨집 사이의 거리 (최단거리)
도시의 치킨 거리 : 모든 집의 치킨 거리의 합
두 칸 사이의 거리 = |r1-r2| + |c1-c2| (가로 세로 거리 합)

M개의 치킨집만 남겼을때 도시의 치킨거리의 최솟값 구하기
 */

public class boj15686 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m;
    static int[][] map;
    static int min = Integer.MAX_VALUE;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]> storeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        System.out.println(min);
    }

    public static void dfs(int count, int nowRow, int nowCol) {
        if (count == m) {
            // 거리 구하기
            int distance = findAllDistance();

            if (distance < min) {
                min = distance;
            }
            return;
        }

        for (int row = nowRow; row < n; row++) {

            //다음 행으로 바뀌면 0번열부터 검사, 아니라면 기존 열의 다음 행부터 검사
            int startCol;
            if (row == nowRow) {
                startCol = nowCol;
            }
            else {
                startCol = 0;
            }

            for (int col = startCol; col < n; col++) {
                if (map[row][col] == 2) {
                    storeList.add(new int[]{row, col});
                    dfs(count + 1, row, col + 1);
                    storeList.remove(storeList.size() - 1);
                }
            }
        }
    }

    public static int findAllDistance() {
        int[][] nowMap = new int[n][n];
        int allDistance = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 2) {
                    nowMap[i][j] = map[i][j];
                }
            }
        }

        for (int[] store : storeList) {
            nowMap[store[0]][store[1]] = 2;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nowMap[i][j] == 1) {
                    allDistance += findDistance(i, j, nowMap);
                }
            }
        }

        return allDistance;
    }

    // 집의 좌표와 m개의 치킨집만 남은 맵으로 그 집에서의 최단거리 구하기
    public static int findDistance(int row, int col, int[][] nowMap) {
        int[][] visited = new int[n][n];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        visited[row][col] = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            if (nowMap[x][y] == 2) {
                return Math.abs(row - x) + Math.abs(col - y);
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (visited[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = 1;
                    }
                }
            }
        }
        return 0;
    }

}

/*
tmpMap 에 M개의 치킨집만 남긴 맵을 복사
tmpMap 기준으로 최솟값 구하기
기존 min 값보다 작다면 교체

- 치킨집중 m개를 고르는 방법
- 각 집마다 최소거리를 구하는 방법
>>> m개를 고르고 각 집마다 거리를 구해서 다 더한 다음 min 과 비교후 -> 다음 케이스로 진행

x개중 m개 고르기 는 bfs?
리스트에 맵을 돌면서 m개를 넣는다
count로 m개를 고를 때까지 재귀, m개를 골랐다면 base condition
-> 리스트에 있는 좌표들로 새로운 tmpMap을 만들고 그거로 최소거리 계산
 */
