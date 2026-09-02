import java.io.*;
import java.util.*;

/*
boj1920 수 찾기
 */

public class boj1920 {
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
            System.out.println(find(num));
        }

    }

    public static int find(int target) {
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
