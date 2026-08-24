import java.io.*;
import java.util.*;

/*
boj 9095 1, 2, 3 더하기 - 정수 n을 1, 2, 3의 합으로 나타내는 방법의 수
*/

public class boj9095 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp = new int[11];
    static int n;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int current = 4; current <= 10; current++) {
            dp[current] = dp[current - 3] + dp[current - 2] + dp[current - 1];
        }

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
