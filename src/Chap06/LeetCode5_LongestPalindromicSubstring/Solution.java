package Chap06.LeetCode5_LongestPalindromicSubstring;

import java.util.Arrays;

/**
 * 문자열에서 가장 긴 팰린드롬 찾아서 반환.
 * 숫자와 영어문자만 가짐.
 * 문자 길이가 짝수일때와 홀수 일때 구분 ?
 */

class Solution {
    public String longestPalindrome(String s) {
        // 한글자는 팰린드롬
        if (s.length() <= 1) {
            return s;
        }

        char[] words = s.toCharArray();
        String longest = "";

        for (int i = 0; i < words.length; i++) {
            String find = findPalindrome(words, i);

            if (longest.length() < find.length()) {
                longest = find;
            }
        }
        return longest;
    }

    // i번째 위치를 중심으로 팰린드롬 찾기
    public String findPalindrome(char[] words, int i) {
        int start = i;
        int end = i;
        boolean flag = true;

        while (start >= 0 && end < words.length && flag) {
            if (words[start] == words[end]) {
                start--;
                end++;
            }
            else {
                flag = false;
            }
        }

        String finded1 = new String(words).substring(start + 1, end);

        start = i;
        end = i + 1;
        flag = true;

        while (start >= 0 && end < words.length && flag) {
            if (words[start] == words[end]) {
                start--;
                end++;
            }
            else {
                flag = false;
            }
        }

        String finded2 = new String(words).substring(start + 1, end);

        if (finded1.length() > finded2.length()) {
            return finded1;
        }
        else {
            return finded2;
        }

    }

}