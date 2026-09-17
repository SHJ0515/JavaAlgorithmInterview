import java.io.*;
import java.util.*;

public class boj1620 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            map1.put(i, name);
            map2.put(name, i);
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (Character.isDigit(s.charAt(0))) {
                int num = Integer.parseInt(s);
                System.out.println(map1.get(num));
            } else {
                System.out.println(map2.get(s));
            }
        }
    }
}
