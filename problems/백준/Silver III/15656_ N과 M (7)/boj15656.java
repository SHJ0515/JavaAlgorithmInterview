import java.util.*;
import java.io.*;

/*
N怨?M(7)
N媛?以?M媛?(N? 紐⑤몢 ?ㅻⅨ ??
媛숈? ???щ윭踰?媛???ъ쟾 ??利앷?

 */

public class boj15656 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static boolean[] visited;

    static int n;
    static int m;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 1 <= m <= n <= 8
        n = 4;
        m = 2;
        arr = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        func(0);
    }

    public static void func(int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : list) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < n; i++) {
            list.add(arr[i]);
            func(depth + 1);
            list.remove(list.size() - 1);
        }
    }
}
