package Chap07.LeetCode15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0){
                    left++;
                }
                else if (sum > 0){
                    right--;
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    answer.add(list);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return answer;
    }
}
/*
세수의 합
배열을 입력받아 합으로 0을 만들 수 있는 3개의 엘리먼트를 출력
- 배열 오름차순 정렬
- i : 0 ~ n - 2 까지 반복
- i의 바로 뒤와 배열의 맨 끝을 left right 지정
- i, left, right의 합이 0이면 리스트에 저장 아니면 left right 이동
 */