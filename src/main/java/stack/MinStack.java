package stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/description/
 *
 * if new element i < min: push min and set min = i. this marks the min so far.
 * during pop: if s.pop() == min: min = s.pop(). this sets the min for the elements in stack
 */
public class MinStack {

    int min = Integer.MAX_VALUE;
    Stack<Integer> st = new Stack<>();

    public void push(Integer i) {
        if (i <= min) {
            st.push(min);
            min = i;
        }
        st.push(i);
    }

    public int pop() {
        int i = st.pop();
        if (i == min) {
            min = st.pop(); //double pop
        }
        return i;
    }

    public int min() {
        return min;
    }

    public int top() {
        return st.peek();
    }

    public static void main(String[] arg) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min()); //  --> Returns -3.
        minStack.pop();
        System.out.println(minStack.top());    //  --> Returns 0.
        minStack.min();
    }
}
