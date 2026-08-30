import java.io.*;
import java.util.*;

/*
BOJ11399 ATM
 */

public class boj11399 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] time;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        time = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                sum += time[j];
            }
        }
        System.out.println(sum);
    }
}
