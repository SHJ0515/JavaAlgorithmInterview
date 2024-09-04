package Chap06.LeetCode937_ReorderLogFiles;
import java.util.ArrayList;
import java.util.List;
public class SolutionTest {
    public static void main(String[] args) {
        String[] test1 = {"id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero"};

        Solution solution = new Solution();
        test1 = solution.reorderLogFiles(test1);

        for(String log : test1){
            System.out.println(log);
        }

    }


}
