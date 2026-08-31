import java.io.*;
import java.util.*;

/*
BOJ1929 소수 구하기 - M 이상 N 이하의 소수를 모두 출력 (1 <= M <= N <= 1,000,000)

에라토스테네스의 채
  1. 2부터 N까지의 모든 수를 소수 후보.
  2. 아직 제거되지 않은 가장 작은 수를 선택.
  3. 선택한 수가 p라면 p의 배수를 제거.
  4. 배수 제거는 p × p부터 시작.
  5. 다음으로 제거되지 않은 수를 선택.
  6. 선택한 수의 제곱이 N 이하인 동안 3~5단계를 반복.
  7. 제곱이 N을 초과하면 반복을 종료.
  8. 끝까지 제거되지 않은 수들이 소수.
 */

public class boj1929 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static boolean[] nums = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 2; i < 1000001; i++) {
            nums[i] = true;
        }
        func();

        for (int i = m; i <= n; i++) {
            if (nums[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }

    static void func() {
        for (int i = 2; i * i <= 1000000; i++) {
            if (!nums[i]) {
                continue;
            }
            remove(i);
        }
    }

    static void remove(int num) {
        int start = num * num;
        for (int i = start; i <= 1000000; i = i + num) {
            nums[i] = false;
        }
    }
}
