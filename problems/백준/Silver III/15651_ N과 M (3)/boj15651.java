/import java.util.*;
import java.io.*;

public class boj15651 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static boolean[] visited;

    static int n;
    static int m;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 1 <= m <= n <= 7
        n = 4;
        m = 2;
        visited = new boolean[n];

        func(0);
    }

    public static void func(int cnt) {
        if (cnt == m) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : list) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < n; i++) {
            list.add(i + 1);
            func(cnt + 1);
            list.remove(list.size() - 1);
        }
    }
}
