import java.io.*;
import java.util.*;

/*
N과 M (8)
- N개 중 M개
- 같은 수를 여러 번 골라도 된다
- 비내림차순 (a1 <= a2 <= a3 ..... <= an)
 */

public class boj15657 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, 0);
    }

    public static void dfs(int count, int idx) {
        if (count == m) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : list) {
                sb.append(i).append(' ');
            }
            System.out.println(sb);
            return;
        }

        for (int i = idx; i < n; i++) {
            list.add(arr[i]);
            dfs(count + 1, i);
            list.remove(list.size() - 1);
        }
    }

}
