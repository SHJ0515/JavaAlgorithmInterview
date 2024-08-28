package Chap06.LeetCode344_ReverseString;

public class Solution {
    public void reverseString(char[] s) {
        int length = s.length;
        int start = 0, end = length - 1;
        char temp;

        while (start < end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }
}

/*
문자열을 뒤집는 함수 작성, 입력값은 문자 배열, 리턴 하지 않고 문자배열을 직접 조작.

처음 생각한 풀이
- 문자배열의 크기를 구함
- 맨 앞과 맨 뒤를 char temp 를 이용해서 직접 교환하기


 */