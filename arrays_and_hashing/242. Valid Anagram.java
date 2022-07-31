// https://leetcode.com/problems/valid-anagram/

import java.util.*;

// Runtime: 99 ms, faster than 5.01% of Java online submissions for Valid Anagram.
// Memory Usage: 47.8 MB, less than 5.59% of Java online submissions for Valid Anagram.

class Solution {
    public boolean isAnagram(String s, String t) {
        ArrayList<Character> anagramChecker1 = new ArrayList<Character>();
        ArrayList<Character> anagramChecker2 = new ArrayList<Character>();
        
        int sLen = s.length();
        int tLen = t.length();
        
        for (int i = 0; i < sLen; i++) {
            anagramChecker1.add(s.charAt(i));
        }
        
        for (int i = 0; i < tLen; i++) {
            if (anagramChecker1.contains(t.charAt(i))) {
                anagramChecker2.add(t.charAt(i));
            } else {
                return false;
            }
        }
        Collections.sort(anagramChecker1);
        Collections.sort(anagramChecker2);
        
        return anagramChecker1.equals(anagramChecker2);
    }
}

// Runtime: 6 ms, faster than 60.35% of Java online submissions for Valid Anagram.
// Memory Usage: 44.2 MB, less than 46.04% of Java online submissions for Valid Anagram.

class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] ana = new int[26];
        for (char c : s.toCharArray()) ana[c - 'a']++;
        for (char c : t.toCharArray()) if (--ana[c -'a'] < 0) return false;
        return true;
    }
}