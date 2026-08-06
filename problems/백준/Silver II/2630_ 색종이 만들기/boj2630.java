import java.util.*;
import java.io.*;

/*
백준 2630 색종이 만들기
- 정사각형 종이는 흰색(0) 또는 파란색(1)
- 전체 종이가 같은 색이 아니면 4등분
- 흰색 색종이와 파란색 색종이의 개수 구하기
 */

public class boj2630 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] paper;
    static boolean[] visited;

    static int n;
    static int blue = 0;
    static int white = 0;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = 8;
        paper = new int[n][n];      // white : 0 blue : 1
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void func(int startX, int startY, int size) {
        // base condition : 종이 분할 완료
        if (isPaper(startX, startY, size)) {
            return;
        }

        int nextSize = size / 2;
        func(startX, startY, nextSize);
        func(startX + nextSize, startY, nextSize);
        func(startX, startY + nextSize, nextSize);
        func(startX + nextSize, startY + nextSize, nextSize);
    }

    private static boolean isPaper(int startX, int startY, int size) {
        boolean flag = true;
        int first = paper[startX][startY];

        // 색종이 색 구별
        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if (paper[i][j] == first) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }

        if (flag) {
            if (first == 0) {
                white++;
            } else {
                blue++;
            }
        }
        return flag;
    }
}

/*
 * [누적합(Prefix Sum)을 이용한 풀이]
 *
 * 1. prefix[i][j]를 (0, 0)부터 (i - 1, j - 1)까지 포함한
 *    파란색(1) 칸의 개수로 정의한다.
 *
 *    int[][] prefix = new int[n + 1][n + 1];
 *    for (int i = 1; i <= n; i++) {
 *        for (int j = 1; j <= n; j++) {
 *            prefix[i][j] = paper[i - 1][j - 1]
 *                    + prefix[i - 1][j]
 *                    + prefix[i][j - 1]
 *                    - prefix[i - 1][j - 1];
 *        }
 *    }
 *
 * 2. (startX, startY)에서 크기가 size인 영역의 파란색 수는 O(1)에 구한다.
 *
 *    int endX = startX + size;
 *    int endY = startY + size;
 *    int blueCount = prefix[endX][endY]
 *            - prefix[startX][endY]
 *            - prefix[endX][startY]
 *            + prefix[startX][startY];
 *
 * 3. blueCount로 영역의 단색 여부를 판단한다.
 *
 *    if (blueCount == 0) {
 *        white++;
 *        return; // 전부 흰색
 *    }
 *    if (blueCount == size * size) {
 *        blue++;
 *        return; // 전부 파란색
 *    }
 *
 *    // 둘 다 아니라면 색이 섞여 있으므로 기존처럼 4등분 재귀 호출
 *
 * 누적합 구성: O(N^2)
 * 분할 재귀: 각 노드에서 단색 확인 O(1), 전체 노드 수 O(N^2)
 * 전체 시간: O(N^2), 추가 공간: O(N^2) (prefix 배열)
 */
