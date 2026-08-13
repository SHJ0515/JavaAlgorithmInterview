import java.io.*;
import java.util.*;

/*
 * BOJ 18808 스티커 붙이기
 *
 * 스티커는 모눈종이 위에 존재.
 * 불필요한 행 or 열 없음. 스티커는 한덩어리
 *
 * 스티커를 회전시키지 않고 모눈종이에서 떼기
 * 다른 스티커와 겹치거나 노트북을 벗어나지 않으면서 스티커 붙일수 있는 위치 찾기
 * 왼쪽 && 위 부터 채워나가기
 * 스티커를 못붙인다면 90도 회전 후 반복
 * 360도 다 돌려서 못붙인다면 해당 스티커는 버리기
 *
 */
public class boj18808 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m, k; // 노트북 세로, 노트북 가로, 스티커 개수
    static int[][] laptop;

    static List<int[][]> stickerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        laptop = new int[n][m];

        for (int i = 0; i < k; i++) {
            setSticker();
        }

        for (int i = 0; i < k; i++) {
            int[][] tmpSticker = stickerList.get(i);

            for (int j = 0; j < 4; j++) {
                // 붙였으면 탈출, 못붙였으면 roll
                if (canAttach(tmpSticker)) {
                    break;
                }
                tmpSticker = rolling(tmpSticker);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (laptop[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    //스티커를 90도 회전 후 리턴
    public static int[][] rolling(int[][] target) {
        int n = target.length;
        int m = target[0].length;
        int[][] after = new int[m][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                after[c][n - r - 1] = target[r][c];
            }
        }
        return after;
    }

    // 현재 상태의 스티커를 노트북에 붙일 수 있는지 찾기. -> 붙일 수 있다면 스티커를 붙인 후 true 리턴, 끝까지 못붙였으면 false 리턴
    public static boolean canAttach(int[][] sticker) {
        int row = sticker.length;
        int col = sticker[0].length;

        // i,j는 laptop에서 시작점
        for (int i = 0; i <= n - row; i++) {
            for (int j = 0; j <= m - col; j++) {

                // 해당 위치 스티커 부착 가능여부 체크
                boolean flag = true;
                for (int l = 0; l < row && flag; l++) {
                    for (int o = 0; o < col && flag; o++) {
                        if (sticker[l][o] == 1 && laptop[i + l][j + o] == 1) {
                            flag = false;
                        }
                    }
                }

                // 부착 불가능시 continue 후 다음 위치 진행
                if (!flag) {
                    continue;
                }

                // 부착 가능시 붙이고 true 리턴
                for (int l = 0; l < row; l++) {
                    for (int o = 0; o < col; o++) {
                        if (sticker[l][o] == 1) {
                            laptop[i + l][j + o] = sticker[l][o];
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void setSticker() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int stickerN = Integer.parseInt(st.nextToken());
        int stickerM = Integer.parseInt(st.nextToken());

        int[][] sticker = new int[stickerN][stickerM];
        for (int i = 0; i < stickerN; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < stickerM; j++) {
                sticker[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        stickerList.add(sticker);
    }
}