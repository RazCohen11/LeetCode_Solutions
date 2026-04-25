# Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
# 
#  
# 
# Example 1:
# 
# Input: target = 7, nums = [2,3,1,2,4,3]
# Output: 2
# Explanation: The subarray [4,3] has the minimal length under the problem constraint.
# Example 2:
# 
# Input: target = 4, nums = [1,4,4]
# Output: 1
# Example 3:
# 
# Input: target = 11, nums = [1,1,1,1,1,1,1,1]
# Output: 0
#  
# 
# Constraints:
# 
# 1 <= target <= 109
# 1 <= nums.length <= 105
# 1 <= nums[i] <= 104
#  
# 
# Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).

class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        s, e, minSubArr = 0, 0, len(nums) + 1
        curSum = nums[s]
        
        while e < len(nums):
            if curSum < target:
                e += 1
                if e < len(nums):
                    curSum += nums[e]
            else:
                if e - s + 1 < minSubArr:
                    minSubArr = e - s + 1
                if s == e:
                    e += 1
                    if e < len(nums):
                        curSum += nums[e]
                else:
                    s += 1
                    curSum -= nums[s - 1]

        if minSubArr == len(nums) + 1:
            return 0
        return minSubArr