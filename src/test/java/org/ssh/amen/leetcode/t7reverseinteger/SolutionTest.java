package org.ssh.amen.leetcode.t7reverseinteger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.ssh.amen.leetcode.t7reverseinteger.Solution.reverse;

class SolutionTest {
    @Test
    void testReverseInteger(){
        assertEquals(123, reverse(321));
        assertEquals(-123, reverse(-321));
        assertEquals(21, reverse(120));
        assertEquals(0, reverse(1534236469));
        assertEquals(-2147483648, reverse(-2147483648));
    }
}