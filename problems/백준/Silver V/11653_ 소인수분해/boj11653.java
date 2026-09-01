import java.io.*;
import java.util.*;

/*
BOJ11653 소인수분해 */

public class boj11653 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int i = 2;

        StringBuilder sb = new StringBuilder();
        while (n != 1 && i * i <= n) {
            if (n % i == 0) {
                n = n / i;
                sb.append(i).append('\n');
            }
            else {
                i++;
            }
        }
        if (n != 1){
            sb.append(n);
        }
        System.out.println(sb);
    }
}
