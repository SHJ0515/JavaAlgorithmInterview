package Chap06.LeetCode49_GroupAnagrams;

import java.util.List;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = solution.groupAnagrams(strs);
        System.out.println("lists = " + lists);
    }
}
