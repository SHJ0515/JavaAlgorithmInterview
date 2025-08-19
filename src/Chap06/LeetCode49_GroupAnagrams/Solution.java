package Chap06.LeetCode49_GroupAnagrams;

import java.util.*;

// 애너그램 -> 사전순 정렬 시 모두 같음 이용 e.g. (ate, eta) -> 정렬 시 둘 다 aet 가 된다
// 단어 정렬, 같은 단어끼리 묶어서 맵 보관

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> answer = new HashMap<>();

        for (String str : strs) {

            char[] s = str.toCharArray();
            Arrays.sort(s);

            String sorted = new String(s);    // toString 사용시 원하는 값 X "[C@1b6d3586" 같은게 나온다.

            //원본 문자열 = str, 사전순 정렬 문자열 = sorted

            if (!answer.containsKey(sorted)) {
                answer.put(sorted, new ArrayList<>());
                answer.get(sorted).add(str);
            }
            else {
                answer.get(sorted).add(str);
            }
        }

        List<List<String>> group = new ArrayList<>(answer.values());
        return group;
    }
}