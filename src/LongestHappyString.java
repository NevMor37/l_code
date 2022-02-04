import java.util.PriorityQueue;

/**
 * A string s is called happy if it satisfies the following conditions:
 *
 * s only contains the letters 'a', 'b', and 'c'.
 * s does not contain any of "aaa", "bbb", or "ccc" as a substring.
 * s contains at most a occurrences of the letter 'a'.
 * s contains at most b occurrences of the letter 'b'.
 * s contains at most c occurrences of the letter 'c'.
 * Given three integers a, b, and c, return the longest possible happy string.
 * If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = 1, b = 1, c = 7
 * Output: "ccaccbcc"
 * Explanation: "ccbccacc" would also be a correct answer.
 * Example 2:
 *
 * Input: a = 7, b = 1, c = 0
 * Output: "aabaa"
 * Explanation: It is the only correct answer in this case.
 *
 *
 * Constraints:
 *
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 */
public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        Pair pa = new Pair('a', a);
        Pair pb = new Pair('b', b);
        Pair pc = new Pair('c', c);

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.count - x.count);

        if(a>0)
            pq.offer(pa);
        if(b>0)
            pq.offer(pb);
        if(c>0)
            pq.offer(pc);

        StringBuilder sb = new StringBuilder();
        while(pq.size() >= 2) {
            Pair most = pq.poll();
            if(most.count >= 2) {
                sb.append(most.c);
                sb.append(most.c);
                most.count-=2;
            } else {
                sb.append(most.c);
                most.count--;
            }

            Pair second = pq.poll();
            if(second.count >= 2 && second.count > most.count) {
                sb.append(second.c);
                sb.append(second.c);
                second.count-=2;
            } else {
                sb.append(second.c);
                second.count--;
            }

            if(most.count > 0) pq.offer(most);
            if(second.count >0) pq.offer(second);
        }

        if(!pq.isEmpty()) {
            if(sb.length() == 0 || pq.peek().c != sb.charAt(sb.length()-1)) {
                Pair top = pq.poll();
                if(top.count >= 2) {
                    sb.append(top.c);
                    sb.append(top.c);
                } else {
                    sb.append(top.c);
                }
            }
        }

        return sb.toString();

    }

     class Pair {
        char c;
        int count;

        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
     }
}
