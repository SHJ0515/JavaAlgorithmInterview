package Chap06.LeetCode937_ReorderLogFiles;

import java.util.*;

public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letter = new ArrayList<>();
        List<String> digit = new ArrayList<>();

        // 문자 로그, 숫자 로그 구분
        for (String log : logs) {
            String[] s = log.split(" ");

            if (Character.isDigit(s[1].charAt(0))) {
                digit.add(log);
            } else {
                letter.add(log);
            }
        }

        Collections.sort(letter, new Comparator<String>(){
            @Override   // Comparator<String>()
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" ", 2);   // split(" ") 이면 공백에 따라 다 나뉘어짐 -> "idx", "art", "can"
                String[] s2 = o2.split(" ", 2);   // split(" ", 2) 이면 첫번째 공백 기준으로 앞뒤로 나누어짐 -> "idx", "art can"

                if(s1[1].compareTo(s2[1]) == 0 ){       // 문자가 동일 한 경우엔 식별자 순 리턴
                    return s1[0].compareTo(s2[0]);
                }
                else{
                    return s1[1].compareTo(s2[1]);      // 문자가 다르면 문자 사전 순 리턴
                }
            }
        });


        letter.addAll(digit);

        return letter.toArray(new String[0]);  // list를 String[]로 변환 후 return
    }
}

/*
로그파일 재정렬
- 제일 앞의 식별자는 순서에 영향 x
- 문자로 구성된 로그가 숫자로 구성된 로그보다 앞에 옴
- 문자 로그는 사전 순 정렬
- 문자가 동일 한 경우엔 식별 자 순
- 숫자 로그는 입력 순서로

point
- 숫자와 문자를 나누어서 정렬 후 두개를 연결하자
- Collections 과 Comparator을 이용해서 비교 및 정렬 연산을 쉽게 수행하자, 직접 하드코딩해서 만들 생각 하지 말고
- 주어진 자료형인 String[]에 매몰되지 말고 List 등 사용하면 좋은 자료형들을 생각해내 계산하자.

 */