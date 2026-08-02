import java.util.*;
import java.io.*;

/**
 * 諛깆? N怨?M (5)
 * N媛쒖쓽 ?먯뿰?섏? M
 * N媛쒖쓽 ?먯뿰??以?M媛?怨좊Ⅸ ?섏뿴
 * N媛쒖쓽 ?먯뿰?섎뒗 紐⑤몢 ?ㅻⅨ ?? * ?섏뿴? ?ъ쟾 ??利앷?
 */

public class boj15654 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static boolean[] visited;

    static int n;
    static int m;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 1 <= m <= n <= 8
        n = 4;
        m = 4;
        arr = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        func(0);
    }

    public static void func(int cur) {
        if (cur == m) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : list) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(arr[i]);
            func(cur + 1);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
