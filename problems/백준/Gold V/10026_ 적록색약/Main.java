import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        String[][] map = new String[n][n];
        int[][] normalVisited = new int[n][n];      //일반인
        int[][] colorVisited = new int[n][n];        //적록색약

        // 맵에 RGB 입력
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = split[j];
            }
        }

        int normalCount = 0;
        Queue<int[]> normalQueue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (map[i][j].equals("R") && normalVisited[i][j] == 0) {
                    normalCount++;
                    normalQueue.add(new int[]{i, j});

                    while (!normalQueue.isEmpty()) {
                        int[] poll = normalQueue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = poll[0] + dx[k];
                            int ny = poll[1] + dy[k];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                if (map[nx][ny].equals("R") && normalVisited[nx][ny] == 0) {
                                    normalQueue.add(new int[]{nx, ny});
                                    normalVisited[nx][ny] = 1;
                                }
                            }
                        }
                    }
                }
                else if (map[i][j].equals("G") && normalVisited[i][j] == 0) {
                    normalCount++;
                    normalQueue.add(new int[]{i, j});

                    while (!normalQueue.isEmpty()) {
                        int[] poll = normalQueue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = poll[0] + dx[k];
                            int ny = poll[1] + dy[k];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                if (map[nx][ny].equals("G") && normalVisited[nx][ny] == 0) {
                                    normalQueue.add(new int[]{nx, ny});
                                    normalVisited[nx][ny] = 1;
                                }
                            }
                        }
                    }
                }
                else if (map[i][j].equals("B") && normalVisited[i][j] == 0) {
                    normalCount++;
                    normalQueue.add(new int[]{i, j});

                    while (!normalQueue.isEmpty()) {
                        int[] poll = normalQueue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = poll[0] + dx[k];
                            int ny = poll[1] + dy[k];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                if (map[nx][ny].equals("B") && normalVisited[nx][ny] == 0) {
                                    normalQueue.add(new int[]{nx, ny});
                                    normalVisited[nx][ny] = 1;
                                }
                            }
                        }
                    }
                }
            }
        }

        int colorCount = 0;
        Queue<int[]> colorQueue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (map[i][j].equals("B") && colorVisited[i][j] == 0) {
                    colorCount++;
                    colorQueue.add(new int[]{i, j});

                    while (!colorQueue.isEmpty()) {
                        int[] poll = colorQueue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = poll[0] + dx[k];
                            int ny = poll[1] + dy[k];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                if (map[nx][ny].equals("B") && colorVisited[nx][ny] == 0) {
                                    colorQueue.add(new int[]{nx, ny});
                                    colorVisited[nx][ny] = 1;
                                }
                            }
                        }
                    }
                }
                else if ((map[i][j].equals("R") || map[i][j].equals("G")) && colorVisited[i][j] == 0) {
                    colorCount++;
                    colorQueue.add(new int[]{i, j});

                    while (!colorQueue.isEmpty()) {
                        int[] poll = colorQueue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = poll[0] + dx[k];
                            int ny = poll[1] + dy[k];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                if ((map[nx][ny].equals("R") || map[nx][ny].equals("G")) && colorVisited[nx][ny] == 0) {
                                    colorQueue.add(new int[]{nx, ny});
                                    colorVisited[nx][ny] = 1;
                                }
                            }
                        }
                    }
                }

            }
        }

        sb.append(normalCount).append(" ").append(colorCount);
        System.out.println(sb);
    }
}




/*
크기 N X N
각 칸에 R G B 가능
R / G / B 끼리 상하좌우로 인접해 있으면 같은 구역

적록색약 -> R G 구분 x RG / B 로 나뉨
일반인이 봤을때와 적록색약이 봤을때의 구역 수 구하기
BFS 각각 진행하기
 */