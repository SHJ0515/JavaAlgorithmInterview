import java.io.*;
import java.util.*;

/*
boj 1149 RGB거리
- N개의 집
- 집 색은 R G B 중 하나
- 1번과 2번의 색은 달라야 함
- N번과 N-1번의 색은 달라야 함
- i번은, i-1, i+1 의 색과 달라야 함
- R G B로 칠하는 비용 존재,
- 모든 집을 칠하는 최솟값 구하기
 */

public class boj1149 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] dp;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][3];
        cost = new int[n + 1][3];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][0] = cost[1][0];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int min = Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
        System.out.println(min);
    }
}
