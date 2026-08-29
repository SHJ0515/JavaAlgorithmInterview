import java.io.*;
import java.util.*;

/*
BOJ 1026 보물
- 길이 N인 정수 배열 A, B
- S = A[0] x B[0] + A[1] x B[1] + ... + A[N-1] x B[N-1]
- S의 값이 가장 작아지게 A를 재배열, B는 건들지 않음
- S의 최솟값 출력

 1 <= N <= 50
 0 <= A[],B[] <= 100
 */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        B = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        /*
        A의 가장 작은값을 B의 가장 큰 값과 매치되게 위치 변경
        B는 건들지 말라 했지만 사실상 A를 오름차, B를 내림차 정렬 후 둘이 곱하기
         */
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i] * B[n - i - 1];
        }
        System.out.println(sum);
    }
}