import java.io.*;
import java.util.*;

/*
boj1202 보석 도둑

- 보석 총 N개, 각 보석마다 무게 m, 가격 v 존재
- K개의 가방 존재, 각 가방에 담을 수 있는 최대 무게 C
- 가방에는 최대 한 개의 보석만 넣을 수 있음
*/

public class boj1202 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;
    static long values = 0;
    static int[] bags;
    static Jewel[] jewels;

    static class Jewel implements Comparable<Jewel> {
        int weight;
        int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            int result = Integer.compare(this.weight, o.weight);

            if (result == 0) {
                result = Integer.compare(this.value, o.value);
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        jewels = new Jewel[n];
        bags = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Jewel jewel = new Jewel(m, v);
            jewels[i] = jewel;
        }
        Arrays.sort(jewels);

        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        func();
    }

    public static void func() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;

        for (int i = 0; i < bags.length; i++) {
            while (idx < n && jewels[idx].weight <= bags[i]) {
                pq.offer(jewels[idx].value);
                idx++;
            }

            if (!pq.isEmpty()) {
                values += pq.poll();
            }
        }
        System.out.println(values);
    }
}
