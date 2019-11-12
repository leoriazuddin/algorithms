package stack;

import java.util.Stack;

/**
 * Implement a queue using exactly two stacks. Return -1 if both stacks are empty.
 *
 * Approach 1 (used here): S1 always has the elements in order
 *  enqueue i:
 *      move all elements from S1 to S2
 *      push i to S1
 *      move back elements to S1
 *  dequeue:
 *      return top of S1
 *
 * Approach 2: Keep one stack empty at all times. This avoids moving back elements to S1 as in Approach 1
 *  enqueue i:
 *      if S1 is empty, push i to S1, else to S2
 *      move all elements from non empty stack to stack where i is pushed.
 *  dequeue:
 *      if both stacks are empty return -1
 *      return top of non-empty stack
 */
public class QueueStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(int i) {
        if (s1.empty()) {
            s1.push(i);
        } else
        {
            while(!s1.empty())
                s2.push(s1.pop());

            s1.push(i);

            while(!s2.empty()) {
                s1.push(s2.pop());
            }
        }
    }

    public int dequeue() {
        return s1.pop();
    }
}
