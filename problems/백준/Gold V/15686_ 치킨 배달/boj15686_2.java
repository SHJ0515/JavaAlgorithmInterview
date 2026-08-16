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

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
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
        int allDistance = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    int tmpDistance = Integer.MAX_VALUE;
                    for (int[] ints : storeList) {
                        int distance = Math.abs(i - ints[0]) + Math.abs(j - ints[1]);
                        if (distance < tmpDistance) {
                            tmpDistance = distance;
                        }
                    }
                    allDistance += tmpDistance;
                }
            }
        }

        return allDistance;
    }
}