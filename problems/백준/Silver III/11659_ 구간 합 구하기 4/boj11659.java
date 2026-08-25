import java.io.*;
import java.util.*;

public class boj11659 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[] prefix;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        prefix = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        prefix[1] = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= n; i++) {
            prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(prefix[end] - prefix[start - 1]);
        }
    }
}
