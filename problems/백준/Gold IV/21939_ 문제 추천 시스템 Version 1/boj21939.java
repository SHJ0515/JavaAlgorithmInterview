import java.io.*;
import java.util.*;

/*
boj21939 문제 추천 시스템 Version 1

- 문제번호, 난이도 정리
- recommend x : x가 1인경우 가장 어려운 문제 번호 출력, 여러개라면 가장 큰 번호 출력, -1인 경우 가장 쉬운, 여러개라면 가장 작은 번호 출력
- add P L : 난이도가 L인 문제번호 P추가
- solved P : 문제번호 P 제거

 */

public class boj21939 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Problem implements Comparable<Problem> {
        int number;
        int level;

        public Problem(int number, int level) {
            this.number = number;
            this.level = level;
        }

        @Override
        public int compareTo(Problem o) {
            int compare = Integer.compare(this.level, o.level);

            if (compare == 0) {
                compare = Integer.compare(this.number, o.number);
            }
            return compare;
        }
    }

    public static void main(String[] args) throws IOException {
        TreeSet<Problem> treeSet = new TreeSet<>();
        Map<Integer, Problem> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Problem problem = new Problem(p, l);
            treeSet.add(problem);
            map.put(p, problem);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                Problem problem = new Problem(p, l);
                treeSet.add(problem);
                map.put(p, problem);
            }
            else if (command.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());
                Problem problem = map.remove(p);
                treeSet.remove(problem);
            }
            else {
                if (treeSet.isEmpty()) {
                    continue;
                }
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    System.out.println(treeSet.last().number);
                }
                else {
                    System.out.println(treeSet.first().number);
                }
            }
        }
    }
}
