/**
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue
 * (push, peek, pop, and empty).
 *
 * Implement the MyQueue class:
 *
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as
 * long as you use only a stack's standard operations.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 1, 1, false]
 *
 * Explanation
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 *
 *
 * Constraints:
 *
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, peek, and empty.
 * All the calls to pop and peek are valid.
 *
 *
 * Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words,
 * performing n operations will take overall O(n) time even if one of those operations may take longer.
 *
 *class MyQueue {
 *
 *    Stack<Integer> stack;
 *     Stack<Integer> temp;
 *     public MyQueue() {
 *         this.stack = new Stack<>();
 *         this.temp = new Stack<>();
 *     }
 *
 *     public void push(int x) {
 *         stack.push(x);
 *     }
 *
 *     public int pop() {
 *         while(!stack.isEmpty()) {
 *             temp.push(stack.pop());
 *         }
 *         int res = temp.pop();
 *         while(!temp.isEmpty()) {
 *             stack.push(temp.pop());
 *         }
 *         return res;
 *     }
 *
 *     public int peek() {
 *         while(!stack.isEmpty()) {
 *             temp.push(stack.pop());
 *         }
 *         int res = temp.peek();
 *         while(!temp.isEmpty()) {
 *             stack.push(temp.pop());
 *         }
 *         return res;
 *     }
 *
 *     public boolean empty() {
 *         return this.stack.isEmpty();
 *     }
 * }
 */
import java.util.*;
public class ImplementQueueUsingStacks {
}
class MyQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    int front;
    public MyQueue() {

    }

    public void push(int x) {
        if (s1.empty())
            front = x;
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }

    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
