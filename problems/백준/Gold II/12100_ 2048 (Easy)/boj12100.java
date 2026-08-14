import java.io.*;
import java.util.*;

/*
백준 12100 2048
보드의 크기 N
보드 초기상태 제공
최대 5번이동시켜 얻을수있는 최대 값 구하기
 */

public class boj12100 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int[][] board;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = find(board);

        dfs(board, 0);
        System.out.println(max);
    }

    public static void dfs(int[][] nowBoard, int moveCount) {
        if (moveCount == 5) {
            int tmp = find(nowBoard);
            if (tmp > max) {
                max = tmp;
            }
            return;
        }

        //상하좌우 4번 이동 체크
        for (int i = 0; i < 4; i++) {
            //int[][] copyBoard = copy();
            switch (i) {
                case 0 -> {
                    int[][] nextBoard = moveLeft(nowBoard);
                    dfs(nextBoard, moveCount + 1);
                }
                case 1 -> {
                    int[][] nextBoard = moveRight(nowBoard);
                    dfs(nextBoard, moveCount + 1);
                }
                case 2 -> {
                    int[][] nextBoard = moveUp(nowBoard);
                    dfs(nextBoard, moveCount + 1);
                }
                case 3 -> {
                    int[][] nextBoard = moveDown(nowBoard);
                    dfs(nextBoard, moveCount + 1);
                }
            }
        }
    }

    public static int[][] moveLeft(int[][] nowBoard) {
        int[][] nextBoard = new int[n][n];

        for (int row = 0; row < n; row++) {
            int previous = 0;
            int index = 0;

            for (int col = 0; col < n; col++) {
                int current = nowBoard[row][col];

                if (current == 0) {        //현재칸이 0이면 볼 필요가 없으니 다음 칸으로 이동
                    continue;
                }

                if (previous == 0) {       //이전칸이 0이면 현재칸을 이전칸 위치로 이동
                    previous = current;
                }
                else if (previous == current) {
                    nextBoard[row][index++] = 2 * previous;  //이전칸과 값이 같다면 합치고 index위치에 저장
                    previous = 0;                          //합치고 나면 기존칸은 0이됨
                }
                else {
                    nextBoard[row][index++] = previous;      //이전과 현재가 다르면 안합쳐짐, 이전값을 그대로 index 위치에 저장
                    previous = current;
                }
            }

            // 남은 값 있다면 기록 e.g. 2 0 2 2 -> 4 기록 후 previous = 2 남은 채로 반복문 종료
            if (previous != 0) {
                nextBoard[row][index] = previous;
            }
        }

        return nextBoard;
    }

    public static int[][] moveRight(int[][] nowBoard) {
        int[][] nextBoard = new int[n][n];

        for (int row = 0; row < n; row++) {
            int previous = 0;
            int index = n - 1;

            for (int col = n - 1; col >= 0; col--) {
                int current = nowBoard[row][col];

                if (current == 0) {
                    continue;
                }

                if (previous == 0) {
                    previous = current;
                }
                else if (previous == current) {
                    nextBoard[row][index--] = previous * 2;
                    previous = 0;
                }
                else {
                    nextBoard[row][index--] = previous;
                    previous = current;
                }
            }

            if (previous != 0) {
                nextBoard[row][index] = previous;
            }
        }

        return nextBoard;
    }

    public static int[][] moveUp(int[][] nowBoard) {
        int[][] nextBoard = new int[n][n];

        for (int col = 0; col < n; col++) {
            int previous = 0;
            int index = 0;

            for (int row = 0; row < n; row++) {
                int current = nowBoard[row][col];

                if (current == 0) {
                    continue;
                }

                if (previous == 0) {
                    previous = current;
                }
                else if (previous == current) {
                    nextBoard[index++][col] = 2 * previous;
                    previous = 0;
                }
                else {
                    nextBoard[index++][col] = previous;
                    previous = current;
                }
            }

            if (previous != 0) {
                nextBoard[index][col] = previous;
            }
        }

        return nextBoard;
    }

    public static int[][] moveDown(int[][] nowBoard) {
        int[][] nextBoard = new int[n][n];

        for (int col = 0; col < n; col++) {
            int index = n - 1;
            int previous = 0;

            for (int row = n - 1; row >= 0; row--) {
                int current = nowBoard[row][col];

                if (current == 0) {
                    continue;
                }

                if (previous == 0) {
                    previous = current;
                }
                else if (previous == current) {
                    nextBoard[index--][col] = 2 * previous;
                    previous = 0;
                }
                else {
                    nextBoard[index--][col] = previous;
                    previous = current;
                }
            }

            if (previous != 0){
                nextBoard[index][col] = previous;
            }
        }

        return nextBoard;
    }

    public static int find(int[][] nowBoard) {
        int tmpMax = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nowBoard[i][j] > tmpMax) {
                    tmpMax = nowBoard[i][j];
                }
            }
        }
        return tmpMax;
    }
}
