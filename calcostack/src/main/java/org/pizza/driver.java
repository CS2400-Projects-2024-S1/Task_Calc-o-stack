package org.pizza;

//temp file

public class driver {
    public class LinkedStackTest {
        public void main(String[] args) {
            // Create a LinkedStack object
            LinkedStack<Integer> stack = new LinkedStack<Integer>();
        
            // Test cases
            String infix1 = "a*b/(c-a)+d*e";
            String infix2 = "(a+b)/(c-d)";
            String infix3 = "a/(b-c)*d";
            String infix4 = "a-(b/(c-d)*e+f)^g";
            String infix5 = "(a-b*c)/(d*e^f*g+h)";
        
            // Test infix conversion to postfix
            String postfix1 = stack.convertToPostfix(infix1);
            String postfix2 = stack.convertToPostfix(infix2);
            String postfix3 = stack.convertToPostfix(infix3);
            String postfix4 = stack.convertToPostfix(infix4);
            String postfix5 = stack.convertToPostfix(infix5);
            
            // Print results
            System.out.println("Converted " + infix1 + " to " + postfix1);
            System.out.println("Converted " + infix2 + " to " + postfix2);
            System.out.println("Converted " + infix3 + " to " + postfix3);
            System.out.println("Converted " + infix4 + " to " + postfix4);
            System.out.println("Converted " + infix5 + " to " + postfix5);
        }
    }

    public static void main(String[] args) {
        // Create a ResizeableArrayStack object
        ResizeableArrayStack<Integer> stack = new ResizeableArrayStack<>();
    
        // Test cases
        String postfix1 = "26+35-/";
        String postfix2 = "234*5*-";
        String postfix3 = "234-/5*";
        String postfix4 = "6342^*+5-";
    
        // Test postfix evaluation
        int result1 = stack.evaluatePostfix(postfix1);
        int result2 = stack.evaluatePostfix(postfix2);
        int result3 = stack.evaluatePostfix(postfix3);
        int result4 = stack.evaluatePostfix(postfix4);

        // Print results
        System.out.println("Result of " + postfix1 + " = " + result1);
        System.out.println("Result of " + postfix2 + " = " + result2);
        System.out.println("Result of " + postfix3 + " = " + result3);
        System.out.println("Result of " + postfix4 + " = " + result4);
    }
}
