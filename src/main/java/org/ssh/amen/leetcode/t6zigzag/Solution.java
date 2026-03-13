package org.ssh.amen.leetcode.t6zigzag;

public class Solution {

    public static String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        Character[][] rows = new Character[numRows][s.length()];
        int[] rowChar = new int[numRows];

        int currentRow = 0;
        int currentCol = 0;
        int currentChar = 0;
        for (int i = 0; currentChar < s.length(); i++) {
            if (currentCol%(numRows-1) != 0 && ((numRows-1)-(currentCol%(numRows-1))) != currentRow) {
                rows[currentRow][rowChar[currentRow]++] = null;
            } else {
                rows[currentRow][rowChar[currentRow]++] = s.charAt(currentChar++);
            }

            currentRow++;
            if (currentRow%numRows== 0) {
                currentCol++;
            }
            currentRow = currentRow%numRows;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (rows[i][j] != null) {
                    sb.append(rows[i][j]);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        convert("PAYPALISHIRING", 3);
        convert("PAYPALISHIRING", 4);
    }
}
