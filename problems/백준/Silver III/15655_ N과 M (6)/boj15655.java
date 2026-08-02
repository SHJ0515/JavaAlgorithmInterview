import java.util.*;
import java.io.*;

/*
N과 M(6)
N개 중 M개 (N은 모두 다른 수)
오름차순

 */

public class boj15655 {

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
        func(0, 0);
    }

    public static void func(int cur, int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : list) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        //오름차순 정렬 후 재귀는 내 idx 다음부터 진행 -> 중복 없이 오름차순 지키기 가능
        for (int i = cur; i < n; i++) {
            list.add(arr[i]);
            func(i + 1, depth + 1);
            list.remove(list.size() - 1);
        }
    }
}

