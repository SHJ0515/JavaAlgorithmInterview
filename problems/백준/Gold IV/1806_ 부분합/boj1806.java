import java.io.*;
import java.util.*;

public class boj1806 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, s;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(find());
    }

    public static int find() {
        int answer = n + 1;
        int left = 0;
        int right = 0;
        int sum = 0;

        // right 이동시키며 sum >= s 인 구간 찾기, sum = [left, right)
        // sum >= s 일 때, left를 이동시키며 >= s 이며 길이가 가장 짧은 구간 찾기
        while (right < n) {
            sum += arr[right];
            right++;

            while (sum >= s) {
                answer = Math.min(answer, right - left);
                sum -= arr[left];
                left++;
            }
        }

        if (answer != n + 1) {
            return answer;
        }
        return 0;
    }
}
