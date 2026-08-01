package Chap07.LeetCode42_TrappingRainWater;

import java.util.*;
import java.util.stream.*;

class Solution {
    public int trap(int[] height) {

        Deque<Integer> deque = new ArrayDeque<>();
        int volume = 0;

        for (int i = 0; i < height.length; i++) {

            while (!deque.isEmpty() && height[i] > height[deque.peek()]) {
                int top = deque.pop();

                //스택에 한개만 있던경우 -> 첫번째 인덱스 -> 좌측이 없으므로 여기는 빗물을 채울 수 없음
                if (deque.isEmpty()) {
                    break;
                }

                // 스택의 마지막까지의 거리
                int distance = i - deque.peek() - 1;

                int water = Math.min(height[i], height[deque.peek()]) - height[top]; // top 기준 좌우 중 더 작은 값과 비교
                volume = volume + distance * water;
            }
            deque.push(i);
        }
        return volume;
    }
}

/*
  빗물의 양 구하기
  내 좌우가 나보다 높으면, 둘중 낮은값만큼 빗물 참
  2 1 0 1 3 -> 3칸 참


 */