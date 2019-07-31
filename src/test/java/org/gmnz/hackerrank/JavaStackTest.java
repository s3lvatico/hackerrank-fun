package org.gmnz.hackerrank;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class JavaStackTest {

    private JavaStack stack;

    @Test
    public void hrExercise() {
        Scanner s = new Scanner(JavaStackTest.class.getResourceAsStream("/javaStackTest2.txt"));
        String input;

        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put('(', ')');
        parentheses.put('[', ']');
        parentheses.put('{', '}');

        while (s.hasNext()) {
            input = s.next();
            System.out.println("input : " + input);
            boolean isValid = true;
            stack = new JavaStack();
            char c;
            for (int i = 0; i < input.length(); i++) {
                c = input.charAt(i);
                if (parentheses.containsKey(c))
                    stack.push(parentheses.get(c));
                else if (parentheses.containsValue(c)) {
                    char popped = stack.pop();
                    isValid = c == popped;
                }
                if (!isValid)
                    break;
            }
            // a fine analisi, se ci sono anora elementi nello stack vuol dire che ci sono
            // parentesi sbilanciate
            if (isValid)
                isValid = stack.size() == 0;
            System.out.println(isValid);
        }
        s.close();
        Assert.assertTrue(true);
    }

}