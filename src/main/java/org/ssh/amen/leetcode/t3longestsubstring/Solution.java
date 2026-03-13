package org.ssh.amen.leetcode.t3longestsubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int length = 0;
            for (int j = i; j < s.length(); j++) {
                char singleChar = s.charAt(j);

                set.add(singleChar);
                int newLength = set.size();
                if (length == newLength){
                    break;
                }
                length = newLength;
                if (maxLength < newLength){
                    maxLength = newLength;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring(" "));
    }
}
