/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
 */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Boolean> map = new HashMap<>();
        int index = 0;
        
        while (index <= k && index < nums.length) {
            if (map.getOrDefault(nums[index], false)) {
                return true;
            }
            map.put(nums[index], true);
            index++;
        }
        for (int i = 0; i < nums.length - k - 1; i++) {
            map.put(nums[i], false);
            if (map.getOrDefault(nums[i + k + 1], false)) {
                return true;
            }
            map.put(nums[i + k + 1], true);
        }
        return false;
    }
}