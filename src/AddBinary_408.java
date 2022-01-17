/**
 * Description
 * Given two binary strings, return their sum (In binary notation).
 *
 * Example
 * Example 1:
 *
 * Input:
 * a = "0", b = "0"
 * Output:
 * "0"
 * Example 2:
 *
 * Input:
 * a = "11", b = "1"
 * Output:
 * "100"
 */
public class AddBinary_408 {
    public static String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        return a.length() > b.length() ? cal(a, b) : cal(b, a);
    }

    public static String cal(String a, String b) {
        int inc = 0;
        StringBuilder res = new StringBuilder();
        for(int i=0; i<a.length(); i++) {
            int cb = i < b.length() ? b.charAt(i)-'0' : 0;
            int ca = a.charAt(i)-'0';
            res.append((cb + ca + inc) % 2);
            inc = cb + ca + inc> 1 ? 1 : 0;
        }
        if(inc > 0) res.append(1);
        return res.reverse().toString();
    }

    public static void main(String ... args) {
        System.out.println(addBinary("1", "1"));
    }
}
