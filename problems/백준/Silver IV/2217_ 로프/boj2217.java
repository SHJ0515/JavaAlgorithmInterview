import java.io.*;
import java.util.*;

/*
BOJ 2217 로프
- N개의 로프 (1 <= N <= 100000)
- 로프마다 들 수 있는 물체 중량 다름
- 로프 병렬 연결 시 w/k 만큼씩 고르게 분산
- 로프를 이용해서 들수 있는 물체의 최대중량 고르기
- 모든로프를 쓸 필요는 x

e.g. 모든로프를 쓸때보다 이득인 경우
- 10 100 견디는게 가능한 경우 -> 100만 쓰면 됨, 둘다 쓰면 10에 걸리고 최대 20으로 더 낮음
 */

public class boj2217 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] rope;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        rope = new int[n];
        for (int i = 0; i < n; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);

        /*
        가장 작은 무게의 로프 사용 -> 모든 로프를 써서 분산한다.
        두번째로 작은 무게의 로프 사용 -> 가장 작은 로프 제외 모든 로프를 써서 분산한다
        n번째 -> n번째 로프만 쓴다
        1 ~ N 비교해서 더 큰것만 채택.
        */
        int weight = 0;
        int tmpWeight = 0;

        for (int i = 0; i < n; i++) {
            tmpWeight = rope[i] * (n - i);
            if (tmpWeight > weight) {
                weight = tmpWeight;
            }
        }
        System.out.println(weight);
    }
}