import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String[] tokens;

        int n = Integer.parseInt(br.readLine()); // 한 줄 입력 후 정수 변환

        br.close(); // BufferedReader 닫기
        bw.flush();
        bw.close();
    }
}
