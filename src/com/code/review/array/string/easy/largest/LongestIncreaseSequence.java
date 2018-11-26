package com.code.review.array.string.easy.largest;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreaseSequence {
	  /**
    	Thoughts:
		O(nLogN) using binary serach.
		Maintain a list of nums in increasing order.
		When considering new num:
		- See if it can append (num > last-max-num from the list)
		- If not, do binary search with the list and see where the number may fit.
		- Every time, set num to where may fit in the list (find the smallest item from list which also > num)
		Why setting a number in the list?
		The list works as a baseline, which adjusts dynamically: any number less than the baseline won't be able to append.
		However, it can hellp refine (lower) the baseline, which potentially allow future number to append.
		In the end, return the size of list.
     */
    public int lengthOfLIS(int[] nums) {
      
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (list.size() == 0 || nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int index = binarySearch(list, nums[i]);
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }
     public int binarySearch(List<Integer> list, int target) {
        int start = 0;
        int end = list.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return list.get(start) >= target ? start : end;
    }
}