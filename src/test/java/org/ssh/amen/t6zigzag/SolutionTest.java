package org.ssh.amen.t6zigzag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.ssh.amen.t6zigzag.Solution.convert;

class SolutionTest {

    @Test
    public void testConvert(){
        assertEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", convert("PAYPALISHIRING", 4) );
        assertEquals("A", convert("A", 1));
    }

}