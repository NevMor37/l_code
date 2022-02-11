/**
 * Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
 *
 * Implement the FreqStack class:
 *
 * FreqStack() constructs an empty frequency stack.
 * void push(int val) pushes an integer val onto the top of the stack.
 * int pop() removes and returns the most frequent element in the stack.
 * If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 *
 *
 * Example 1:
 *
 * Input
 * ["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
 * [[], [5], [7], [5], [7], [4], [5], [], [], [], []]
 * Output
 * [null, null, null, null, null, null, null, 5, 7, 5, 4]
 *
 * Explanation
 * FreqStack freqStack = new FreqStack();
 * freqStack.push(5); // The stack is [5]
 * freqStack.push(7); // The stack is [5,7]
 * freqStack.push(5); // The stack is [5,7,5]
 * freqStack.push(7); // The stack is [5,7,5,7]
 * freqStack.push(4); // The stack is [5,7,5,7,4]
 * freqStack.push(5); // The stack is [5,7,5,7,4,5]
 * freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
 * freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
 * freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
 * freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
 *
 *
 * Constraints:
 *
 * 0 <= val <= 109
 * At most 2 * 104 calls will be made to push and pop.
 * It is guaranteed that there will be at least one element in the stack before calling pop.
 */
import java.util.*;
public class MaximumFrequencyStack {
    class FreqStack {
        Map<Integer, Integer> map;
        Map<Integer, Stack<Integer>> freqStack;
        int maxFreq;
        public FreqStack() {
            this.map = new HashMap<>();
            this.freqStack = new HashMap<>();
            this.maxFreq = 0;
        }

        public void push(int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            int freq = map.get(val);
            if(freqStack.get(freq) == null) {
                freqStack.put(freq, new Stack());
            }
            freqStack.get(freq).push(val);
            if(freq > maxFreq) {
                maxFreq = freq;
            }
        }

        public int pop() {
            Stack<Integer> stack = freqStack.get(maxFreq);
            int res = stack.pop();
            if(stack.isEmpty()) {
                maxFreq--;
            }
            map.put(res, map.get(res) -1);
            return res;
        }
    }
}

//O(log(n))
class FreqStack {
    PriorityQueue<Element> pq;
    Map<Integer, Element> map;
    int time;
    public FreqStack() {
        Comparator<Element> comparator = new Comparator<>() {
            @Override
            public int compare(Element o1, Element o2) {
                if(o1.freq == o2.freq) {
                    return o2.time - o1.time;
                }
                return o2.freq - o1.freq;
            }
        };
        this.pq = new PriorityQueue<>(comparator);
        this.map = new HashMap<>();
        this.time = 0;
    }

    public void push(int val) {
        time++;
        if(!map.containsKey(val)) {
            Element e = new Element();
            e.freq = 1;
            e.timeStack.push(time);
            e.time = e.timeStack.peek();
            e.val = val;
            map.put(val, e);
            pq.offer(e);
        } else {
            Element e = map.get(val);
            pq.remove(e);
            e.freq +=1;
            e.timeStack.push(time);
            e.time = e.timeStack.peek();
            pq.offer(e);
        }
    }

    public int pop() {
        Element e = pq.poll();
        e.freq--;
        if(e.freq == 0) {
            map.remove(e.val);
        } else {
            e.timeStack.pop();
            e.time = e.timeStack.peek();
            pq.offer(e);
        }
        return e.val;
    }

    class Element {
        int val;
        int freq;
        int time;
        Stack<Integer> timeStack = new Stack<>();
    }
}

