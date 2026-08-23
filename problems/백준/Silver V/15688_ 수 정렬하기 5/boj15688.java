import java.io.*;
import java.util.*;

/*
boj 15688
 */

public class boj15688 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] arr = new int[2000001];  // idx 0 ~ 1000000, 1000001 ~ 2000000

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            num = num + 1000000;
            arr[num]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2000001; i++) {
            for (int j = 0; j < arr[i]; j++) {
                sb.append(i - 1000000).append('\n');
            }
        }
        System.out.println(sb);


    }
}
