import java.io.*;
import java.util.*;

public class boj11726 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 2) {
            System.out.println(2);
            return;
        }

        dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = dp[i] % 10007;
        }
        System.out.println(dp[n]);
    }
}
