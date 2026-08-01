package Chap07.LeetCode42_TrappingRainWater;


public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = solution.trap(height);
        System.out.println(trap);
    }
}