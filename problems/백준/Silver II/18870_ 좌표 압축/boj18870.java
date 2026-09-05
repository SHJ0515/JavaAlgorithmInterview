import java.io.*;
import java.util.*;

/*
boj18870 좌표 압축
- 수직선 위에 N개의 좌표 x1 x2.... xn
- xi를 좌표 압축 한 xi'는 xi > xj를 만족하는 서로 다른 좌표 xj의 개수와 같아야 함
- 자기보다 작은 수의 개수 구하기

e.g.
2 4 -10 4 -9 -> 2 3 0 3 1

x의 범위 : -10^9 ~ 10^9
 */

public class boj18870 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] arr;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        tmp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            tmp[i] = arr[i];
        }
        Arrays.sort(tmp);

        int size = 1;
        for (int i = 1; i < n; i++) {
            if (tmp[i] != tmp[size - 1]) {
                tmp[size++] = tmp[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(lowerBound(arr[i], size)).append(' ');
        }
        System.out.println(sb);
    }

    public static int lowerBound(int target, int size) {
        int left = 0;
        int right = size;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (tmp[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
}