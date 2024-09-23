package Chap06.LeetCode819_MostCommonWord;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        /*
        String mostCount = targetList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        return mostCount;
        */

        // 위의 코드와 똑같은 코드
        String mostCount;
        // Step 1: targetList를 스트림으로 변환
        Stream<String> stream = targetList.stream();
        // Step 2: 요소를 그룹화하고, 각 요소의 등장 횟수를 셉니다.
        Map<String, Long> countMap = stream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // Step 3: Map의 entrySet을 스트림으로 변환
        Stream<Map.Entry<String, Long>> entryStream = countMap.entrySet().stream();
        // Step 4: 등장 횟수가 가장 큰 값을 찾습니다.
        Optional<Map.Entry<String, Long>> maxEntry = entryStream.max(Map.Entry.comparingByValue());
        // Step 5: 가장 많이 등장한 요소를 추출합니다.
        Optional<String> mostFrequentElement = maxEntry.map(Map.Entry::getKey);
        // Step 6: 값이 없으면 null을 반환
        mostCount = mostFrequentElement.orElse(null);
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

