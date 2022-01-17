/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 *
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 *
 * 11 is read off as "two 1s" or 21.
 *
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n, generate the nth sequence.
 *
 * The sequence of integers will be represented as a string.
 *
 * Example
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Example 2:
 *
 * Input: 5
 * Output: "111221"
 */
public class CountAndSay_420 {
    public String countAndSay(int n) {
        String start = "1";
        for(int i=1; i<n;i++) {
            start = generate(start);
        }
        return start;
    }
    public String generate(String s) {
        int i=1;
        int count = 1;
        char cur = s.charAt(0);
        StringBuilder res = new StringBuilder();
        char [] arr = s.toCharArray();
        while(i < s.length()) {
            if(arr[i] == arr[i-1]) {
                count++;
            } else {
                res.append(count).append(cur);
                cur = arr[i];
                count = 1;
            }
            i++;
        }
        res.append(count).append(cur);
        return res.toString();
    }

    public static void main(String ... args) {
        CountAndSay_420 countAndSay_420 = new CountAndSay_420();
        System.out.println(countAndSay_420.countAndSay(5));
    }
}
