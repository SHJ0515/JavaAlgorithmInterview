package Chap07.LeetCode1_TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        /*
        key : 값, value : 해당 값의 배열 인덱스
        target - 현재 값이 있고 그 값의 인덱스가 i (지금) 이 아니면 두개 더해서 target이 되는 쌍이 존재한다.
         */
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return null;
    }
}
