package org.ssh.amen.leetcode.t7reverseinteger;

public class Solution {

    public static int reverse(int x) {
        int abs = Math.abs(x);
        long output=Long.parseLong(new StringBuilder(String.valueOf(abs).replaceAll("-", "")).reverse().toString());
        if (output > Integer.MAX_VALUE){
            output = 0;
        }

        return (x<0 ? -(int) output : (int) output);
    }

    public static void main(String[] args) {
        reverse(321);
        reverse(-321);
        reverse(120);
        reverse(-2147483648);
    }
}
