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

/*
String 자료형 유용한 메서드
- 길이확인 : length()
- 문자추출 : charAt(int index)
- 부분 문자열 추출 : subString(int begin, int end)
- 문자열 찾기 : indexOf(String str)
- 문자열 대체 : replace(String target, String replace)
- 대소문자 전환 : toUpperCase(), toLowerCase()
- 문자열 분할 : split(String str)

StringBuilder 자료형 유용한 메서드
- 문자 추가 : append(String str)
- 문자 삭제 : delete(int start, int end)
- 문자 삽입 : insert(int offset, String str)
- 문자열 길이 확인 : length
- 문자열 뒤집기 : reverse()
- 문자열 전환 : toString()
 */

