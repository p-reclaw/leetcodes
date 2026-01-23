package org.ssh.amen.t5longestpalindrome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.ssh.amen.t5longestpalindrome.Solution.isPalindrome;

class SolutionPalindromeTest {

    @Test
    public void testPalindrome(){
        Assertions.assertTrue(isPalindrome("bab"));
        Assertions.assertTrue(isPalindrome("aba"));
        Assertions.assertTrue(isPalindrome("baab"));
        Assertions.assertTrue(isPalindrome("aaadddaaa"));
    }

}