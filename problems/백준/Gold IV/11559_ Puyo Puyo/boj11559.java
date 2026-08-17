import java.io.*;
import java.util.*;

/*
백준 Puyo Puyo

12 X 6 필드
. / R / G / B / P / Y 6가지 문자 존재
.은 빈공간, 나머지는 색상
같은 색상이 4개 이상 모이면 터지고 그 위의 뿌요들은 밑의 공간으로 하강
필드가 주어졌을 때 총 몇연쇄인지 구하기

- 터트릴수 있는지 찾기 -> bfs, 찾으면 true 못찾음 false
- 찾은 것들은 모두 .으로 바꾸고 chain++
- down 시키기
- 터트릴수 있는게 없을 때 까지 반복

 */

public class boj11559 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int chain = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static char[][] field = new char[12][6];
    static int[][] visited = new int[12][6];

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                field[i][j] = s.charAt(j);
            }
        }

        while (findPuyo()) {
            puyo();
            down();
            resetVisited();
        }

        System.out.println(chain);
    }

    public static boolean findPuyo() {
        boolean flag = false;

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (field[i][j] != '.' && visited[i][j] == 0) {
                    Queue<int[]> queue = new ArrayDeque<>();
                    List<int[]> list = new ArrayList<>();
                    queue.add(new int[]{i, j});
                    list.add(new int[]{i, j});
                    visited[i][j] = 1;

                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = poll[0] + dx[k];
                            int ny = poll[1] + dy[k];

                            if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6) {
                                if (field[i][j] == field[nx][ny] && visited[nx][ny] == 0) {
                                    queue.add(new int[]{nx, ny});
                                    list.add(new int[]{nx, ny});
                                    visited[nx][ny] = 1;
                                }
                            }
                        }
                    }
                    // 터트릴수 있는 뿌요 = 2
                    if (list.size() >= 4) {
                        flag = true;
                        for (int[] ints : list) {
                            visited[ints[0]][ints[1]] = 2;
                        }
                    }
                }
            }
        }
        return flag;
    }

    public static void puyo() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (visited[i][j] == 2) {
                    field[i][j] = '.';
                }
            }
        }
        chain++;
    }

    public static void down() {
        for (int i = 0; i < 6; i++) {
            List<Character> list = new ArrayList<>();

            for (int j = 11; j >= 0; j--) {
                if (field[j][i] != '.') {
                    list.add(field[j][i]);
                }
            }
            while (list.size() < 12) {
                list.add('.');
            }

            for (int j = 11; j >= 0; j--) {
                field[j][i] = list.get(11 - j);
            }
        }
    }

    public static void resetVisited() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                visited[i][j] = 0;
            }
        }
    }
}
