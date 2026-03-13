package org.ssh.amen.interview.dynatrace;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.ssh.amen.interview.dynatrace.Task.findMostCommonWords;

class TaskTest {
    @Test
    void testCount(){
        System.out.println(findMostCommonWords("/tmp/file.txt"));
    }
}