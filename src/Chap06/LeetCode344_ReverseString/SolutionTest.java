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

        //이 경우는 "test1 = " 라는 문자열에 test1 변수를 + 연산자로 합치는 **문자열 연결(String Concatenation)**이 먼저 일어납니다
        // char 배열은 toString 재정의 안됨 따라서 해시코드가 나옴
        // System.out.println("test1 = " + test1);
        // 따라서 char 배열을 string 으로 먼저 바꾸기.
        System.out.println("test1 = " + new String(test1));
    }
}
