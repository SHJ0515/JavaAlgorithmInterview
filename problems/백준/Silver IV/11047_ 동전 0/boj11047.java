import java.io.*;
import java.util.*;

public class boj11047 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;
    static int[] coin;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coin = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = n; i >= 1; i--) {
            count = count + k / coin[i];
            k = k % coin[i];
        }
        System.out.println(count);
    }
}
