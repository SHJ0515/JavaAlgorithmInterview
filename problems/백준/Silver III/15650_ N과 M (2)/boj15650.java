import java.util.ArrayList;
import java.util.List;

public class boj15650 {

    static int n = 4;
    static int m = 2;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        func(0, 0);
    }

    public static void func(int cnt, int cur) {
        if (cnt == m) {
            StringBuilder sb = new StringBuilder();
            for (int number : list) {
                sb.append(number).append(' ');
            }
            System.out.println(sb);
            return;
        }

        for (int i = cur; i < n; i++) {
            list.add(i + 1);
            func(cnt + 1, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
