import java.io.*;
import java.util.*;

public class boj2230 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        System.out.println(find());
    }

    public static int find() {
        int left = 0;
        int right = 0;
        int answer = Integer.MAX_VALUE;

        while (left < arr.length && right < arr.length) {
            int difference = arr[right] - arr[left];

            if (difference >= m) {
                answer = Math.min(answer, difference);
                left++;
            } else {
                right++;
            }
        }

        return answer;
    }
}
