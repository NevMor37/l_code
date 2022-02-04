/**
 * Given two integers a and b, return any string s such that:
 *
 * s has length a + b and contains exactly a 'a' letters, and exactly b 'b' letters,
 * The substring 'aaa' does not occur in s, and
 * The substring 'bbb' does not occur in s.
 *
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: "abb"
 * Explanation: "abb", "bab" and "bba" are all correct answers.
 * Example 2:
 *
 * Input: a = 4, b = 1
 * Output: "aabaa"
 *
 *
 * Constraints:
 *
 * 0 <= a, b <= 100
 * It is guaranteed such an s exists for the given a and b.
 */
public class StringWithoutAAAOrBBB {
    public String strWithout3a3b(int a, int b) {
        char ca = 'a';
        char cb = 'b';
        if(b > a) {
            ca = 'b';
            cb = 'a';
            int temp = a;
            a = b;
            b = temp;
        }
        StringBuilder sb = new StringBuilder();
        while(a > 0) {
            sb.append(ca);
            a--;
            if(a>b) {
                sb.append(ca);
                a--;
            }
            if(b > 0) {
                sb.append(cb);
                b--;
            }
        }
        return sb.toString();
    }
    public static void main(String [] args) {
        StringWithoutAAAOrBBB s = new StringWithoutAAAOrBBB();
        s.strWithout3a3b(4,1);
    }
}
