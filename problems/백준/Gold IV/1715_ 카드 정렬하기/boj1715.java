
import java.io.*;
import java.util.*;

/*
boj1715 카드 정렬하기

- 카드 묶음 a와 b를 합치려면 a+b번 비교해야한다.
- 두 묶음 씩 골라 합쳐나가기
- N개의 카드 묶음을 최소한의 비교로 합칠때 비교 횟수 구하기

a <= b <= c 라 할때
case1 : (a+b) + ((a+b)+c) = 2a + 2b + c
case2 : (a+c) + ((a+c)+b) = 2a + b + 2c
case3 : (b+c) + ((b+c)+a) + a + 2b + 2c

case1 <= case2 <= case3
가장 작은 두 수끼리 합쳐 나가는게 제일 작다
 */

public class boj1715 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            priorityQueue.offer(num);
        }

        long count = 0;
        while (priorityQueue.size() > 1) {
            long merged = priorityQueue.poll() + priorityQueue.poll();
            count += merged;
            priorityQueue.offer(merged);
        }
        System.out.println(count);
    }
}
