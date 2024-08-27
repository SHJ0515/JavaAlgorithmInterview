package Chap06.LeetCode125_VaildPalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        String filteredString = filterString(s);
        int length = filteredString.length();
        int start = 0;
        int end = length - 1;

        while(start < end){
            if (filteredString.charAt(start) != filteredString.charAt(end)) {
                return false;
            }
            else{
                start++;
                end--;
            }
        }

        return true;
    }

    private String filterString(String s) {
        StringBuilder newString = new StringBuilder();
        for (char current : s.toCharArray()) {
            if (Character.isLetterOrDigit(current)) {
                newString.append(Character.toLowerCase(current));
            }
        }
        return newString.toString();
    }
}
/*
코드 수정
1. 메소드 명 변경 : change 메소드를 filterString 으로 변경, 메소드 기능 더 명확하게 설명하기
2. 문자열 필터링 개선 : toCharArray 사용해서 반복문을 더 간단하게 만듬
3. isLetterOrDigit() 문자또는 숫자인지 판별 / toLowerCase() 영어대문자를 소문자로 변환 을 사용
4.
 */


/*
public class Solution {
    public boolean isPalindrome(String s) {
        String change = change(s);
        int length = change.length();

        int start = 0;
        int end = length - 1;

        while (start < end) {
            char c1 = change.charAt(start);
            char c2 = change.charAt(end);

            if (c1 != c2) {
                return false;
            } else {
                start++;
                end--;
            }

        }
        return true;
    }

    public String change(String s) {
        StringBuilder newString = new StringBuilder();
        int count = s.length();

        for (int i = 0; i < count; i++) {
            char current = s.charAt(i);
            if (current >= 'a' && current <= 'z' || current >= '0' && current <= '9') {
                newString.append(current);
            } else if (current >= 'A' && current <= 'Z') {
                current = Character.toLowerCase(current);
                newString.append(current);
            }
        }
        return newString.toString();
    }
}
*/


/*
팰린드롬 : 앞뒤가 똑같은 단어나 문장으로, 뒤집어도 같은 말이 되는 단어 or 문장.
영문자와 숫자만을 대상으로 하며, 대소문자 구분 하지 않음.

처음 생각한 풀이.
- 받은 문자열을 영문자, 숫자 제외하고는 모두 없애고 새로운 문자열을 만듬, 이 때 대문자는 소문자로 바꿔서 만듬
- 새로운 문자열을 맨 앞과 맨 뒤를 비교해가면서 전부 일치 시 true 아닌 경우 발생 시 false


A phrase is a palindrome if, after converting all uppercase letters
into lowercase letters and removing all non-alphanumeric characters,
it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
 */