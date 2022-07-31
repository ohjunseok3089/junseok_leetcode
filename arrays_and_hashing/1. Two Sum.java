// https://leetcode.com/problems/two-sum/submissions/
// Runtime: 58 ms, faster than 40.10% of Java online submissions for Two Sum.
// Memory Usage: 45.4 MB, less than 48.59% of Java online submissions for Two Sum.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] returnVal = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if ((i != j) && (target == (nums[i] + nums[j]))) {
                    returnVal = new int[] {i, j};
                }
            }
        }
        return returnVal;
    }
}