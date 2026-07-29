import java.util.*;
import java.io.*;

/**
 * 諛깆? N怨?M (4)
 * ?먯뿰??N怨?M
 * - 1遺??N 以?M媛쒕? 怨좊Ⅸ ?섏뿴
 * - 媛숈? ???щ윭踰?怨좊Ⅴ湲?媛?? * - 怨좊Ⅸ ?섏뿴? 鍮??대┝李⑥닚 ?댁뼱????( a1 <= a2 <= a3 <= ...<= ak) 瑜?留뚯”?섍쾶
 * e.g.
 * 4 2 -> 11 12 13 14 22 23 24 33 34 44
 */

public class boj15652 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static boolean[] visited;

    //    static int cnt = 0;
    static int n;
    static int m;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 1 <= m <= n <= 8
        n = 3;
        m = 3;

        func(0, 0);
    }

    // cur : ?섏뿴 梨꾩슫 媛쒖닔, start : ?꾩옱 ?꾩튂
    public static void func(int cur, int start) {
        if (cur == m) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : list) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = start; i < n; i++) {
            list.add(i + 1);
            func(cur + 1, i);
            list.remove(list.size() - 1);
        }
    }
}
