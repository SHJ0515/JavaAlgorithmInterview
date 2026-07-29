import java.util.*;
import java.io.*;

public class Main {

    static int F, G, U, S, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] split = br.readLine().split(" ");
        F = Integer.parseInt(split[0]);  //건물 총 층수
        S = Integer.parseInt(split[1]);  //현재 위치
        G = Integer.parseInt(split[2]);  //목표 도착층
        U = Integer.parseInt(split[3]);  //위로 이만큼 이동
        D = Integer.parseInt(split[4]);  //아래로 이만큼 이동

        if(!bfs()){
            System.out.println("use the stairs");
        }

    }

    public static boolean bfs() {
        int[] next = new int[]{U, -D};
        int[] visited = new int[F]; // 0 ~ F-1

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{S, 0});
        visited[S - 1] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int move = poll[1];

            if (poll[0] == G) {
                System.out.println(move);
                return true;
            }

            for (int i = 0; i < 2; i++) {
                int nf = poll[0] + next[i];
                if (nf >= 1 && nf <= F) {
                    if (visited[nf - 1] == 0) {
                        queue.add(new int[]{nf, move + 1});
                        visited[nf - 1] = 1;
                    }
                }
            }

        }
        return false;
    }
}



/*
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
총 F층, G층에 스타트링크
S층에서 G층으로 이동

F S G U D 입력받음
 */