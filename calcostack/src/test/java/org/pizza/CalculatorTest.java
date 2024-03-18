package org.pizza;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void testMain() {
        String input = "1\na+b*c\nq\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        Calculator.main(null);
        
        String consoleOutput = outputStream.toString();
        
        assertTrue(consoleOutput.contains("The postfix expression is: abc*+"));
        assertFalse(consoleOutput.contains("Invalid option. Please enter a valid option."));
    }

    
}
