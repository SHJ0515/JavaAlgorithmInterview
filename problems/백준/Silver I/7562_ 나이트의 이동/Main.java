import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수
        for (int i = 0; i < T; i++) {
            int l = Integer.parseInt(br.readLine());

            String[] curLocation = br.readLine().split(" ");
            int curX = Integer.parseInt(curLocation[0]);
            int curY = Integer.parseInt(curLocation[1]);

            String[] targetLocation = br.readLine().split(" ");
            int targetX = Integer.parseInt(targetLocation[0]);
            int targetY = Integer.parseInt(targetLocation[1]);

            int result = bfs(l, curX, curY, targetX, targetY);
            System.out.println(result);
        }
    }

    public static int bfs(int l, int curX, int curY, int targetX, int targetY) {
        int[][] board = new int[l][l];
        board[curX][curY] = 0;
        int[] dx = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = new int[]{-1, 1, 2, -2, 2, -2, -1, 1};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{curX, curY});      //현재 위치로 bfs 시작

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            // 목표 지점 체크
            if (x == targetX && y == targetY) {
                return board[x][y];
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < l && ny >= 0 && ny < l) {
                    if (board[nx][ny] == 0 && !(nx == curX && ny == curY)) {   //시작지점 제외
                        queue.add(new int[]{nx, ny});
                        board[nx][ny] = board[x][y] + 1;
                    }
                }
            }
        }
        return -1;
    }
}


/*
나이트 이동
총 몇번 움직여서 특정 칸으로 이동하는지 체크

체스판 한 변의 길이 : L {0,0} ~ {L-1, L-1} 보드
나이트 현재 칸
나이트가 이동하려고 하는 칸

나이트 이동 : -2 -1 / -2 +1 / -1 +2 / -1 -2 / +1 +2 / +1 -2 / +2 -1 / +2 +1  8가지 경우의 수
-> dx dy 세팅
그대로 bfs 진행

 */