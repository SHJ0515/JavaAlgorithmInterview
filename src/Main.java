
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int bag5 = 0, bag3 = 0;

        //flag가 false가 되면 나머지가 0인 경우 x
        boolean flag = true;

        // 5키로 봉지, 3키로 봉지 5가 최대한 많게

        bag5 = n / 5; // bag5 개수가 가장 많게 시작, 0개까지 줄여나가며 나머지가 0일때 찾기.

        for (int i = bag5; i >= 0; i--) {
            if (isZero(i, n)) {
                bag5 = i;
                bag3 = (n - (5 * i)) / 3;
                break;
            }

            if (i == 0) {
                flag = false;
            }
        }

        if (flag) {
            System.out.println(bag5 + bag3);
        }
        else {
            System.out.println(-1);
        }

        br.close();
        bw.close();
    }

    public static boolean isZero(int bag5, int n) {
        n = n - bag5 * 5;

        if (n % 3 == 0) {
            return true;
        }
        return false;
    }

}
