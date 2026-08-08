import java.io.*;
import java.util.*;

/*
 * BOJ 15683 감시
 *
 * 모든 CCTV의 회전 방향을 조합하여 사각지대의 최솟값을 구한다.
 * 0: 빈 칸, 1~5: CCTV, 6: 벽
 */
public class boj15683 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m, min;
    static int[][] space;
    static int[][] blinded; // 0: 사각지대, 1: 감시된 칸 또는 CCTV, 6: 벽
    static List<Cctv> cctvList = new ArrayList<>();

    static class Cctv {
        int x;
        int y;
        int cctvNum;

        public Cctv(int x, int y, int cctvNum) {
            this.x = x;
            this.y = y;
            this.cctvNum = cctvNum;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        min = n * m;

        space = new int[n][m];
        blinded = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (1 <= tmp && tmp <= 5) {
                    cctvList.add(new Cctv(i, j, tmp));
                }
                space[i][j] = tmp;
            }
        }

        setBlinded();
        dfs(0);
        System.out.println(min);
    }

    public static void dfs(int idx) {
        // 모든 CCTV의 방향을 정한 경우
        if (idx == cctvList.size()) {
            min = Math.min(min, countBlind());
            return;
        }

        Cctv cctv = cctvList.get(idx);

        int directionCount;
        if (cctv.cctvNum == 2) {
            directionCount = 2;
        } else if (cctv.cctvNum == 5) {
            directionCount = 1;
        } else {
            directionCount = 4;
        }

        for (int direction = 0; direction < directionCount; direction++) {
            int[][] backup = copyBlinded();

            switch (cctv.cctvNum) {
                case 1:
                    fillOne(cctv.x, cctv.y, direction);
                    break;
                case 2:
                    fillTwo(cctv.x, cctv.y, direction);
                    break;
                case 3:
                    fillThree(cctv.x, cctv.y, direction);
                    break;
                case 4:
                    fillFour(cctv.x, cctv.y, direction);
                    break;
                case 5:
                    fillFive(cctv.x, cctv.y);
                    break;
            }

            dfs(idx + 1);
            blinded = backup;
        }
    }

    public static int[][] copyBlinded() {
        int[][] copied = new int[n][m];

        for (int i = 0; i < n; i++) {
            copied[i] = blinded[i].clone();
        }
        return copied;
    }

    public static void fillOne(int i, int j, int direction) {
        blinded[i][j] = 1;
        switch (direction) {
            case 0:
                fillRight(i, j + 1);
                break;
            case 1:
                fillLeft(i, j - 1);
                break;
            case 2:
                fillUp(j, i - 1);
                break;
            case 3:
                fillDown(j, i + 1);
                break;
        }
    }

    public static void fillTwo(int i, int j, int direction) {
        blinded[i][j] = 1;
        switch (direction) {
            case 0:
                fillRight(i, j + 1);
                fillLeft(i, j - 1);
                break;
            case 1:
                fillUp(j, i - 1);
                fillDown(j, i + 1);
                break;
        }
    }

    public static void fillThree(int i, int j, int direction) {
        blinded[i][j] = 1;

        switch (direction) {
            case 0:
                fillUp(j, i - 1);
                fillRight(i, j + 1);
                break;
            case 1:
                fillRight(i, j + 1);
                fillDown(j, i + 1);
                break;
            case 2:
                fillDown(j, i + 1);
                fillLeft(i, j - 1);
                break;
            case 3:
                fillLeft(i, j - 1);
                fillUp(j, i - 1);
                break;
        }
    }

    public static void fillFour(int i, int j, int direction) {
        blinded[i][j] = 1;
        switch (direction) {
            case 0:
                fillRight(i, j + 1);
                fillLeft(i, j - 1);
                fillUp(j, i - 1);
                break;
            case 1:
                fillRight(i, j + 1);
                fillUp(j, i - 1);
                fillDown(j, i + 1);
                break;
            case 2:
                fillRight(i, j + 1);
                fillLeft(i, j - 1);
                fillDown(j, i + 1);
                break;
            case 3:
                fillLeft(i, j - 1);
                fillUp(j, i - 1);
                fillDown(j, i + 1);
                break;
        }
    }

    public static void fillFive(int i, int j) {
        blinded[i][j] = 1;
        fillUp(j, i - 1);
        fillDown(j, i + 1);
        fillLeft(i, j - 1);
        fillRight(i, j + 1);
    }

    public static void fillLeft(int i, int tmpLeft) {
        while (tmpLeft >= 0) {
            if (blinded[i][tmpLeft] == 6) {
                break;
            }
            blinded[i][tmpLeft] = 1;
            tmpLeft--;
        }
    }

    public static void fillRight(int i, int tmpRight) {
        while (tmpRight <= m - 1) {
            if (blinded[i][tmpRight] == 6) {
                break;
            }
            blinded[i][tmpRight] = 1;
            tmpRight++;
        }
    }

    public static void fillUp(int j, int tmpUp) {
        while (tmpUp >= 0) {
            if (blinded[tmpUp][j] == 6) {
                break;
            }
            blinded[tmpUp][j] = 1;
            tmpUp--;
        }
    }

    public static void fillDown(int j, int tmpDown) {
        while (tmpDown <= n - 1) {
            if (blinded[tmpDown][j] == 6) {
                break;
            }
            blinded[tmpDown][j] = 1;
            tmpDown++;
        }
    }

    public static int countBlind() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (blinded[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void setBlinded() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (space[i][j] == 6) {
                    blinded[i][j] = 6;
                } else {
                    blinded[i][j] = 0;
                }
            }
        }
    }
}

/*
 * 개선 가능 사항 (현재 문제 크기에서는 필수 아님)
 *
 * 1. 감시 함수들을 방향 배열과 하나의 watch 메소드로 통합할 수 있다.
 * 2. 배열 전체 복사 대신 변경 좌표를 기록해 복구할 수 있다. 다만 현재 입력 크기에서는 복사 방식도 충분히 빠르다.
 */

