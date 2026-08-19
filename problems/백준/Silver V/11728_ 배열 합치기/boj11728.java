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

/*
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;

    public static void main(String[] args) throws IOException {
        int n  = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0, n);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // [start, end)
    public static void mergeSort(int start, int end) {
        int mid = (start + end) / 2;

        if (end - start <= 1) {
            return;
        }

        mergeSort(start, mid);
        mergeSort(mid, end);
        merge(start,end);
    }

    public static void merge(int start, int end) {
        int[] tmpArr = new int[end - start];
        int tmp = 0;
        int mid = (start + end) / 2;

        int p1 = start;
        int p2 = mid;

        while (p1 < mid && p2 < end) {
            if (arr[p1] <= arr[p2]) {
                tmpArr[tmp++] = arr[p1];
                p1++;
            }
            else {
                tmpArr[tmp++] = arr[p2];
                p2++;
            }
        }

        if (p1 == mid) {
            while (p2 < end){
                tmpArr[tmp++] = arr[p2];
                p2++;
            }
        }
        else if (p2 == end){
            while (p1 < mid){
                tmpArr[tmp++] = arr[p1];
                p1++;
            }
        }

        for (int i = 0; i < tmpArr.length; i++) {
            arr[start + i] = tmpArr[i];
        }
    }
}
 */