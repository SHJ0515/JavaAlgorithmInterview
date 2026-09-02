import java.io.*;
import java.util.*;

/*
boj10816 숫자 카드 2
- N개의 숫자 카드
- M개의 정수가 주어졌을 때 각 수의 개수 구하기
- 이진탐색, map 가능
 */

public class boj10816 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            System.out.print(upperBound(num) - lowerBound(num));
            System.out.print(' ');
        }

    }

    // [lower, upper)
    // 왼쪽 경계 (첫번째 target의 위치)
    static int lowerBound(int target) {
        int start = 0;
        int end = n;
        int mid;

        while (start < end) {
            mid = (start + end) / 2;

            if (arr[mid] >= target) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }

    // 오른쪽 경계 (마지막 target의 다음 위치)
    static int upperBound(int target) {
        int start = 0;
        int end = n;
        int mid;

        while (start < end) {
            mid = (start + end) / 2;

            if (arr[mid] <= target) {
                start = mid + 1;
            }
            else {
                end = mid;
            }

        }

        return start;
    }

    // target의 존재 여부
    public static int binarySearch(int target) {
        int start = 0;
        int end = n - 1;
        int middle;

        while (start <= end) {
            middle = (start + end) / 2;
            if (arr[middle] > target) {
                end = middle - 1;
            }
            else if (arr[middle] < target) {
                start = middle + 1;
            }
            else {
                return 1;
            }
        }
        return 0;
    }
}
