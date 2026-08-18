import java.io.*;
import java.util.*;

public class boj11728 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[] a;
    static int[] b;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort();
    }

    public static void mergeSort() {
        int[] arr = new int[n + m];
        int tmp = 0;
        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m) {
            if (a[p1] > b[p2]) {
                arr[tmp++] = b[p2];
                p2++;
            }
            else {
                arr[tmp++] = a[p1];
                p1++;
            }
        }

        if (p1 == n) {
            while (p2 < m) {
                arr[tmp++] = b[p2];
                p2++;
            }

        }
        else if (p2 == m) {
            while (p1 < n) {
                arr[tmp++] = a[p1];
                p1++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n + m; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
