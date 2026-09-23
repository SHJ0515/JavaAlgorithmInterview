
import java.io.*;
import java.util.*;

/*
boj11286 절댓값 힙

 */

public class boj11286 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return Integer.compare(a, b);
            }
            return Integer.compare(Math.abs(a), Math.abs(b));
        });

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                pq.offer(num);
            }
            else {
                if (pq.isEmpty()){
                    System.out.println(0);
                }
                else {
                    System.out.println(pq.poll());
                }
            }
        }
    }
}
