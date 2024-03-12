// task 2 - LinkedStack class instance to implement the algorithm convertToPostfix
import java.util.Stack;

public class LinkedStack {

    // Method to convert infix expression to postfix expression
    public static String convertToPostfix(String infixExpression) {

        // Stack to hold operators
        Stack<Character> stack = new Stack<>();

        // StringBuilder to store the postfix expression
        StringBuilder postfixExpression = new StringBuilder();

        // Iterate through each character 
        for (int i = 0; i < infixExpression.length(); i++) {
            char currentChar = infixExpression.charAt(i);

            // If character is a letter or a digit, add it to postfix 
            if (Character.isLetterOrDigit(currentChar)) {
                postfixExpression.append(currentChar);
            }
            // If character is an opening parenthesis, push it onto the stack
            else if (currentChar == '(') {
                stack.push(currentChar);
            }
            // If character is a closing parenthesis
            else if (currentChar == ')') {
                // Pop operators from stack and append to postfix expression until an opening parenthesis is found
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfixExpression.append(stack.pop());
                }
                // Pop opening parenthesis from the stack
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            // If character is an operator
            else {
                // Pop operators from the stack and append to the postfix expression 
                while (!stack.isEmpty() && precedence(currentChar) <= precedence(stack.peek())) {
                    postfixExpression.append(stack.pop());
                }
                // Push  current operator onto the stack
                stack.push(currentChar);
            }
        }

        // Pop any remaining operators from the stack and append to the postfix 
        while (!stack.isEmpty()) {
            postfixExpression.append(stack.pop());
        }

        // Return the postfix expression as a string
        return postfixExpression.toString();
    }

    // Method to determine the precedence of an operator
    private static int precedence(char operator) {
        switch (operator) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
    
    // testing
    public static void main(String[] args) {
        // infix expression
        String infixExpression = "a+b*c-(d/e+f)*g";
        // infix to postfix
        String postfixExpression = convertToPostfix(infixExpression);
        // print 
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}
