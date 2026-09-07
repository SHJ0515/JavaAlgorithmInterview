import java.io.*;
import java.util.*;

/*
boj2295 세 수의 합 - N( 5 <= N <= 1000)개의 자연수로 이루어진 집합 U
- 집합 U에서 세 수를 골랐을 때 세 수의 합인 d도 U에 포함 가능 - 가장 큰 d를 찾아라
a + b + c = d
-> a + b = d - c
-> a + b / d - c를 각각 N^2로 계산 후 포함 여부가 같다면 a + b + c = d 충족

e.g. {2, 3, 5, 10, 18} 집합 -> 2 + 3 + 5 = 10 / 3 + 5 + 10 = 18 가능. 따라서 답은 d = 18 이 된다.
 */

public class boj2295 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int d = -1;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // a + b
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        // d - c
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = arr[i] - arr[j];
                if (set.contains(num) && arr[i] > d) {
                    d = num + arr[j];
                }
            }
        }
        System.out.println(d);
    }
}
