public class LinkedStackTest {

    public static void main(String[] args) {
        //Define the infix expression
        String infixExpression = "a*b/(c-a)+d*e";

        //Convert the infix expression to postfix using LinkedStack class
        String postfixExpression = LinkedStack.convertToPostfix(infixExpression);

        //Print the infix and postfix expressions
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}
