import java.io.*;
import java.util.*;

/*
BOJ6064 카잉 달력

- 첫번째 해는 <1:1>, 두번째 해는 <2:2>
- <x:y> 다음 해 = <x':y'> 로 표현
- x < M -> x' = x + 1 / x >= M -> x = 1

- x,y가 몇번째 해인지 구하기 */

public class boj6064 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, x, y;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            System.out.println(solve());
        }
    }

    static int solve() {
        if (x == m) {
            x = 0;
        }
        if (y == n) {
            y = 0;
        }

        int lastYear = lcm(m, n);
        for (int year = x; year <= lastYear; year += m) {
            if (year == 0) {
                continue;
            }

            if (year % n == y) {
                return year;
            }
        }
        return -1;
    }

    static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
