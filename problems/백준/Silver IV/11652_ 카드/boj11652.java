import java.io.*;
import java.util.*;

/*
boj 11652 移대뱶
- ?レ옄 移대뱶 N??: -2^62 < ?レ옄 <= 2^62
- 媛??留롮씠 媛吏怨??덈뒗 ?뺤닔 援ы븯湲? ?щ윭媛쒕씪硫?理쒖냼媛? */

public class boj11652 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        long answer = Long.MIN_VALUE;
        long count = 0;

        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0L) + 1);
        }

        for (Long l : map.keySet()) {
            Long tmp = map.get(l);
            if (tmp > count){
                count = tmp;
                answer = l;
            }
            else if (tmp == count) {
                if (answer > l){
                    answer = l;
                }
            }
        }
        System.out.println(answer);
    }
}
