package dev.kartikbhalla;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

    /* Usage Example
        var expression = new Expression("{c/(a+b)}-d");
        System.out.println(expression.isExpressionBalanced());
     */

    private final List leftBrackets = Arrays.asList('(', '[', '{', '<');
    private final List rightBrackets = Arrays.asList(')', ']', '}', '>');
    private String expression;

    Expression(String input) {
        this.expression = input;
    }

    public boolean isExpressionBalanced() {

        Stack<Character> stack = new Stack<>();
        for (char ch : this.expression.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);

            else if (isRightBracket(ch)) {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if (!doBracketsMatch(ch, top)) return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean doBracketsMatch(char right, char left) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }


}
