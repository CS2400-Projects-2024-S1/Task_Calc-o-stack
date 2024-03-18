package org.pizza;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class LinkedStackTest {

    private LinkedStack<Character> stack;

    @BeforeEach
    void setUp() {
        stack = new LinkedStack<>();
    }

    @Test
    void testPushAndPeek() {
        stack.push('1');
        stack.push('2');
        assertEquals('2', stack.peek());
    }

    @Test
    void testPop() {
        stack.push('1');
        stack.push('2');
        assertEquals('2', stack.pop());
        assertEquals('1', stack.pop());
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push('1');
        assertFalse(stack.isEmpty());
    }

    @Test
    void testClear() {
        stack.push('1');
        stack.push('2');
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
    void testConvertToPostfix() {
        assertEquals("ab*ca-/de*+", stack.convertToPostfix("a*b/(c-a)+d*e"));
        assertEquals("ab+cd-/", stack.convertToPostfix("(a+b)/(c-d)"));
        assertEquals("abc-/d*", stack.convertToPostfix("a/(b-c)*d"));
        assertEquals("abcd-/e*f+g^-", stack.convertToPostfix("a-(b/(c-d)*e+f)^g"));
        assertEquals("abc*-def^*g*h+/", stack.convertToPostfix("(a-b*c)/(d*e^f*g+h)"));
    }
}
