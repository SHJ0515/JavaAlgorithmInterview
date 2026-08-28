import java.io.*;
import java.util.*;

public class boj1931 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] meeting;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        meeting = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meeting, (x, y) -> {
            if (x[1] != y[1]) {
                return Integer.compare(x[1], y[1]);
            }
            else {
                return Integer.compare(x[0], y[0]);   //시작 시간 오름차순 e.g. (1,2) (2,2) 일 경우 count = 2 가 돼야하기 때문
            }
        });

        int count = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            if (meeting[i][0] >= time) {
                time = meeting[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
