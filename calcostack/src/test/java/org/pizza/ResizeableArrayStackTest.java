package org.pizza;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResizeableArrayStackTest {

    private ResizeableArrayStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new ResizeableArrayStack<>();
    }

    @Test
    void testPushAndPeek() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
    }

    @Test
    void testPop() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testClear() {
        stack.push(1);
        stack.push(2);
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPopEmptyStack() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    void testPeekEmptyStack() {
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }

    @Test
    void testEvaluatePostfix() {
        assertEquals(-4, stack.evaluatePostfix("26+35-/"));
        assertEquals(-58, stack.evaluatePostfix("234*5*-"));
        assertEquals(-10, stack.evaluatePostfix("234-/5*"));
        assertEquals(49, stack.evaluatePostfix("6342^*+5-"));
    }

}
