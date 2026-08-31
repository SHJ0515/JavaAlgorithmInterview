import java.io.*;
import java.util.*;

/*
BOJ1978 소수 찾기
- 소수 N 이라할때 해당 수의 가장 작은 약수를 x라 가정한다.
- N/x 또한 약수이다
- (x <= N/x) 가 성립 -> (x^2 <= N) -> (x <= 루트 N)
- 따라서 반복문은 i * i <= N (i <= 루트 N) 일 때 까지만 반복문을 돌려서 나눠지는지 아닌지 확인 시 소수 판별이 가능하다
 */

public class boj1978 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            count += func(num);
        }
        System.out.println(count);

    }

    static int func(int num) {
        if (num == 1) {
            return 0;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return 0;
            }
        }
        return 1;
    }

}
