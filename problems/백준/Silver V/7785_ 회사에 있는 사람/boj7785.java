import java.io.*;
import java.util.*;

public class boj7785 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        Set<String> log = new HashSet<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String attendance = st.nextToken();

            if ("enter".equals(attendance)) {
                log.add(name);
            } else {
                log.remove(name);
            }
        }

        List<String> list = new ArrayList<>(log);

        list.sort(Collections.reverseOrder());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
