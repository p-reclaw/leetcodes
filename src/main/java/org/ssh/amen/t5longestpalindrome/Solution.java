package org.ssh.amen.t5longestpalindrome;

public class Solution {

    public static String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String substr = s.substring(i, j);
                if (longest.length() < substr.length() && isPalindrome(substr) ){
                    longest = substr;
                }
            }
        }
        return longest;
    }

    public static boolean isPalindrome(String text){
        if(!text.isEmpty()) {
            for (int i = 0; i < text.length() / 2 + 1; i++) {
                if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
    }
}
