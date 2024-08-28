package Chap06.LeetCode125_VaildPalindrome;

public class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        Solution2 solution2 = new Solution2();

        String test1 = "Do geese see God?";
        String test2 = "Just Failed Result 123!@#";

        System.out.println(s.isPalindrome(test1));
        System.out.println(s.isPalindrome(test2));

        System.out.println(solution2.isPalindrome(test1));
        System.out.println(solution2.isPalindrome(test2));
    }
}
