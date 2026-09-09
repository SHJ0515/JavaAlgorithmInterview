import java.io.*;
import java.util.*;

/*
boj1654 랜선 자르기
- N개의 랜선 만들기
- K개의 랜선을 잘라서 같은 길이의 N개 랜선 만들기
- 만들 수 있는 최대 랜선의 길이 구하기

parametric search
조건을 만족하는 최소/최댓값을 구하는 최적화 문제를 결정 문제로 변환해 이분탐색

최적화 : N개를 만들 수 있는 랜선의 최대 길이
-> 결정 : 랜선의 길이가 X일 때 랜선이 N개 이상인가 아닌가?
 */

public class boj1654 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(find());
    }

    public static long find() {
        long left = 1;
        long right = arr[k - 1];
        long mid, count;

        while (left <= right) {
            mid = (left + right) / 2;
            count = 0;
            for (int i = 0; i < k; i++) {
                count += arr[i] / mid;
            }
            if (count >= n) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return right;
    }
}
