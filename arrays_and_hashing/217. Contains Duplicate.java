import java.util.*;

// https://leetcode.com/problems/contains-duplicate/
// Runtime: 16 ms, faster than 42.72% of Java online submissions for Contains Duplicate.
// Memory Usage: 68.2 MB, less than 73.45% of Java online submissions for Contains Duplicate.

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> dupNums = new HashSet<Integer>();

        for (int i : nums) {
            if (dupNums.contains(i)) {
                return true;
            }
            dupNums.add(i);
        }
        return false;
    }
}