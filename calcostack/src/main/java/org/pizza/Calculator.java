package org.pizza;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Character inputChar = ' ';
        while (inputChar != 'q') {
            System.out.println();
            System.out.println("Calculator Menu");
            System.out.println("----------------");
            System.out.println("1. Convert infix expression to postfix expression");
            System.out.println("2. Evaluate postfix expression");
            System.out.println("Q. Quit the program");
            System.out.println();
            System.out.print("Enter your choice: ");

            try {
                inputChar = scnr.nextLine().charAt(0);
                inputChar = Character.toLowerCase(inputChar);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println();
                System.out.println("No option entered. Please enter a valid option.");
                continue;
            }
            
            System.out.println();
            switch(inputChar) {
                case '1':
                    LinkedStack<Character> ConversionStack = new LinkedStack<>();
                    System.out.print("Enter an infix expression: ");
                    String inputInfixExpression = scnr.nextLine();
                    String outputPostfixExpression = LinkedStack.convertToPostfix(inputInfixExpression);
                    System.out.println("The postfix expression is: " + outputPostfixExpression);
                    break;
                case '2':
                    System.out.println("Enter a postfix expression: ");
                    String inputPostfixExpression = scnr.nextLine();
                    System.out.println("The value of the postfix expression is: ");
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("Invalid option. Please enter a valid option.");
                    break;
            }
        }
        scnr.close();
    }
}
