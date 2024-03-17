public class LinkedStackTest {
    public static void main(String[] args) {
        // Create a LinkedStack object
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
    
        // Test cases
        String infix1 = "a*b/(c-a)+d*e";
    
        // Test infix conversion to postfix
        String postfix1 = stack.convertToPostfix(infix1);
        System.out.println("Converted " + infix1 + " to " + postfix1);
    }
}
