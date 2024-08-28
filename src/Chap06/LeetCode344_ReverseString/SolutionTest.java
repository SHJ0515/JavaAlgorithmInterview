package Chap06.LeetCode344_ReverseString;
public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] test1 = {'s', 't', 'r', 'i', 'n', 'g'};
        char[] test2 = {'a', 'b', 'c', 'd'};

        System.out.println(test1);
        System.out.println(test2);


        solution.reverseString(test1);
        solution.reverseString(test2);

        System.out.println(test1);
        System.out.println(test2);
    }
}
