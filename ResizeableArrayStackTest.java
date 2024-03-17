public class ResizeableArrayStackTest {
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
        System.out.println("Result of " + postfix1 + " = " + result1);
        System.out.println("Result of " + postfix2 + " = " + result2);
        System.out.println("Result of " + postfix3 + " = " + result3);
        System.out.println("Result of " + postfix4 + " = " + result4);
    }
}
