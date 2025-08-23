package Chap06.LeetCode5_LongestPalindromicSubstring;

public class Solution2 {
    int left, maxlen;

    public String longestPalindrome(String s) {

        int length = s.length();
        if (length < 2) {
            return s;
        }

        for (int i = 0; i < length - 1; i++) {
            extendPalindrome(s, i, i + 1);
            extendPalindrome(s, i, i + 2);  // fkf 에서 k가 있든 없든 f끼리만 비교해서 팰린드롬 됨 i+1 무시
        }
        return s.substring(left, left + maxlen);
    }

    public void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            k++;
            j--;
        }

        if (maxlen < k - j - 1) {
            left = j + 1;
            maxlen = k - j - 1;
        }
    }
}
