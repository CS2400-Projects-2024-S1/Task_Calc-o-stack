package org.pizza;

import java.util.Arrays;
import java.util.EmptyStackException;
/**
    A class of stacks whose entries are stored in an array.
    @author Frank M. Carrano
    @author Timothy M. Henry
    @version 4.0
*/
public final class ResizeableArrayStack < T > implements StackInterface < T > {
    private T[] stack; // Array of stack entries
    private int topIndex; // Index of top entry
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    /**
     * Constructs a new resizable array stack with the default capacity.
     * The default capacity is specified by {@link #DEFAULT_CAPACITY}.
     */
    public ResizeableArrayStack() {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    /**
     * Constructs a new resizable array stack with the specified initial capacity.
     * @param initialCapacity the initial capacity of the stack
     * @throws IllegalArgumentException if the specified initial capacity is negative
     *         or greater than the maximum capacity
     */
    public ResizeableArrayStack(int initialCapacity) {
        checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        initialized = true;
    } // end constructor

    /**
     * Adds a new entry to the top of this stack.
     * @param newEntry the object to be added as a new entry
     * @throws SecurityException if this stack is not properly initialized
     */
    public void push(T newEntry) {
        checkInitialization();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    } // end push

    /**
     * Retrieves this stack's top entry.
     * @return the object at the top of the stack
     * @throws EmptyStackException if this stack is empty
     * @throws SecurityException if this stack is not properly initialized
     */
    public T peek() {
        checkInitialization();
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
    } // end peek

    /**
     * Removes and returns this stack's top entry.
     * @return the object that was removed from the top of the stack
     * @throws EmptyStackException if this stack is empty
     * @throws SecurityException if this stack is not properly initialized
     */
    public T pop() {
        checkInitialization();
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        } // end if
    } // end pop

    /**
     * Checks whether this stack is empty.
     * @return true if this stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return topIndex < 0;
    } // end isEmpty

    /**
     * Removes all entries from this stack.
     * @throws SecurityException if this stack is not properly initialized
     */
    public void clear() {
        checkInitialization();

        // Remove references to the objects in the stack,
        // but do not deallocate the array
        while (topIndex > -1) {
            stack[topIndex] = null;
            topIndex--;
        } // end while

        //Assertion: topIndex is -1    
    } // end clear

    /**
     * Throws a security exception if this object is not initialized.
     * @throws SecurityException if this object is not properly initialized
     */
    private void checkInitialization() {
        if (!initialized)
            throw new SecurityException("ResizeableArrayStack object is not initialized properly.");
    } // end checkInitialization

    /**
     * Throws an exception if the client requests a capacity that is too large.
     * @param capacity the capacity to check
     * @throws IllegalStateException if the specified capacity exceeds the maximum capacity
     */
    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a stack " +
                "whose capacity exceeds " +
                "allowed maximum.");
    } // end checkCapacity

    /**
     * Doubles the size of the array stack if it is full.
     * Precondition: checkInitialization has been called.
     */
    private void ensureCapacity() {
        if (topIndex >= stack.length - 1) // If array is full, double its size
        {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        } // end if
    } // end ensureCapacity

    /**
     * Returns a string representation of the stack.
     * The string representation consists of a list of the stack elements
     * in the order they are stored in the array, enclosed in square brackets ("[]").
     * Adjacent elements are separated by the characters ", ".
     * @return a string representation of the stack
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= topIndex; i++) {
            sb.append(stack[i]);
            if (i < topIndex) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Evaluates the given postfix expression and returns the result.
     * @param postfix the postfix expression to be evaluated
     * @return the result of the evaluation
     */
    public Integer evaluatePostfix(String postfix) {
        ResizeableArrayStack < Integer > valueStack = new ResizeableArrayStack < > ();

        for (int i = 0; i < postfix.length(); i++) {
            char nextCharacter = postfix.charAt(i);
            if (Character.isDigit(nextCharacter)) {
                valueStack.push(Character.getNumericValue(nextCharacter));
            } else if (isOperator(nextCharacter)) {
                Integer operandTwo = valueStack.pop();
                Integer operandOne = valueStack.pop();
                Integer result = performOperation(operandOne, operandTwo, nextCharacter);
                valueStack.push(result);
            }
        }

        return valueStack.peek();
    }

    /**
     * Checks if the given character is an operator.
     * @param c the character to be checked
     * @return true if the character is an operator, false otherwise
     */
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    /**
     * Performs the specified arithmetic operation on the given operands.
     * @param operand1 the first operand
     * @param operand2 the second operand
     * @param operator the arithmetic operator
     * @return the result of the operation
     * @throws IllegalArgumentException if the operator is invalid
     */
    private Integer performOperation(int operand1, int operand2, char operator) {
        switch (operator) {
        case '+':
            return operand1 + operand2;
        case '-':
            return operand1 - operand2;
        case '*':
            return operand1 * operand2;
        case '/':
            return operand1 / operand2;
        case '^':
            return (int) Math.pow(operand1, operand2);
        default:
            throw new IllegalArgumentException("Invalid operator");
        }
    }

} // end ResizeableArrayStack