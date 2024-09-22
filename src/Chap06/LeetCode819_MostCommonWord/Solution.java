package Chap06.LeetCode819_MostCommonWord;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 대소문자 구분 없애기, 구두점 없애기
        String cleared = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        // 빈칸 여러 개를 하나의 구분자로 간주하여 단어 나누기
        String[] targets = cleared.split("\\s+");

        List<String> targetList = new ArrayList<>(Arrays.asList(targets));
        List<String> bannedList = new ArrayList<>(Arrays.asList(banned));

        targetList.removeAll(bannedList);

        // 이거 이해 못하겠음 자바스트림 공부필요
        String mostCount = targetList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        return mostCount;

    }

}

/*
금지된 단어를 제외하고 가장 흔하게 등장하는 단어를 출력하라. 대소문자를 구분하지 않으며, 구두점(마췸표, 쉼표 등...) 또한 무시한다
ex) "Ross hit a ball, the hit BALL flew far away after it was hit." / banned = ["hit"] 이 들어왔을 때 출력은 ball
 */

/*
대소문자 구분 x -> lowerCase로 다 소문자로 변환
단어별로 끊어서 String 배열에 저장
배열에 금지단어 존재 시 삭제
개수 세서 가장 많은거 리턴
>>> 구두점 버리기 어떻게?
 */

