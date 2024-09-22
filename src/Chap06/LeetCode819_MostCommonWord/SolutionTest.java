package Chap06.LeetCode819_MostCommonWord;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        String paragraph = "Ross hit a ball, the hit BALL flew far away after it was hit.";
        String[] banned = {"hit"};

        String p2 = "Hello Sejong...   ";

        String returnValue = solution2.mostCommonWord(paragraph, banned);
        System.out.println(returnValue);
    }

}

