import java.io.*;
import java.util.*;

/*
boj 2579 계단 오르기
- 계단을 한번에 한칸 or 두칸 오르기 가능
- 연속된 세개의 계단을 모두 밟기는 불가능, 시작점은 미포함
- 도착 계단은 반드시 밟아야함
- 점수의 최댓값 구하기
 */

public class boj2579 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp;      //idx번째 계단을 밟을 때의 최댓값
    static int[] score;   //각 계단 별 점수
    static int n;

    // x번째 계단을 밟을 때의 최대 = x - 1 번째 계단을 밟고 x번째 오기 vs x-2번째 계단을 밟고 x번째 오기
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1){
            System.out.println(score[1]);
            return;
        }
        if (n == 2){
            System.out.println(score[1] + score[2]);
            return;
        }

        dp[1] = score[1];
        dp[2] = score[2] + score[1];
        dp[3] = Math.max(score[3] + score[2], score[3] + score[1]);
        for (int current = 4; current <= n; current++) {
            // x번째 = (x-2 -> x) OR (x-3 -> x-1 -> x)
            dp[current] = score[current] + Math.max(dp[current - 2], dp[current - 3] + score[current - 1]);
        }

        System.out.println(dp[n]);
    }
}