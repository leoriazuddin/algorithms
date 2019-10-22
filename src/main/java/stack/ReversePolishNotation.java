package stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
public class ReversePolishNotation {

    Stack<Integer> st = new Stack<>();

    public int run(String[] input) {
        for (String s : input) {
            if (s.equals("*")) {
                st.push(st.pop() * st.pop());
            } else if (s.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            } else if (s.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);
            } else if (s.equals("+")) {
                st.push(st.pop() + st.pop());
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        ReversePolishNotation m = new ReversePolishNotation();
        String[] ip = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(m.run(ip));
    }
}
