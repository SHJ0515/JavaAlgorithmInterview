import java.io.*;
import java.util.*;

/*
boj7662 이중 우선순위 큐
 */

public class boj7662 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            operate();
        }
    }

    public static void operate() throws IOException {
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            Integer num = Integer.parseInt(st.nextToken());

            if (oper.equals("I")) {
                treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
            }
            else {
                if (treeMap.isEmpty()){
                    continue;
                }

                if (num == 1) {
                    int key = treeMap.lastKey();
                    if (treeMap.get(key) == 1) {
                        treeMap.pollLastEntry();
                    }
                    else {
                        treeMap.put(key, treeMap.get(key) - 1);
                    }
                }
                else {
                    int key = treeMap.firstKey();
                    if (treeMap.get(key) == 1) {
                        treeMap.pollFirstEntry();
                    }
                    else {
                        treeMap.put(key, treeMap.get(key) - 1);
                    }
                }
            }
        }
        if (treeMap.isEmpty()){
            System.out.println("EMPTY");
        }
        else {
            System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
        }
    }
}
