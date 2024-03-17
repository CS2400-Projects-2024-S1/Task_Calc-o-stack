public class LinkedStackTest {
    public static void main(String[] args) {
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
