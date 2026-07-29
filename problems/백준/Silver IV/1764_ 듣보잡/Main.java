import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        Set<String> seeSet = new HashSet<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String in = br.readLine();
            seeSet.add(in);
        }

        for (int i = 0; i < m; i++) {
            String in = br.readLine();
            if(seeSet.contains(in)){
                list.add(in);
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (String tmp : list) {
            System.out.println(tmp);
        }
    }
}