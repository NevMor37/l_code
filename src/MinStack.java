import java.util.*;

/**
 * Stack<Integer> stack;
 *     Stack<Integer> minStack;
 *     int min = Integer.MAX_VALUE;
 *     public MinStack() {
 *         stack = new Stack<>();
 *         minStack = new Stack<>();
 *     }
 *
 *     public void push(int val) {
 *         stack.push(val);
 *         min = Math.min(min, val);
 *         minStack.push(min);
 *     }
 *
 *     public void pop() {
 *         minStack.pop();
 *         stack.pop();
 *         if(!stack.isEmpty()) min = minStack.peek();
 *         else min = Integer.MAX_VALUE;
 *     }
 *
 *     public int top() {
 *         return stack.peek();
 *     }
 *
 *     public int getMin() {
 *         return min;
 *     }
 */
public class MinStack {
    Stack<Integer> stack;
    int min;
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val <= min) {
            stack.push(min);
            stack.push(val);
            min = val;
        } else {
            stack.push(val);
        }
    }

    public void pop() {
        if(stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
