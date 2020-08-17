package stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {

    Stack<Character> stack = new Stack<>();

    public boolean isValid(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.empty()) {
                return false;
            }

            char top = stack.peek();
            if ((c == ']' && top == '[') || (c == '}' && top == '{') || (c == ')' && top == '(')) {
                stack.pop();
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        ValidParentheses p = new ValidParentheses();
        System.out.println(p.isValid("{}{}{[][]}{[}"));
    }
}
