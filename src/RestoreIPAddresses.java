/**
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any
 * digits in s. You may return the valid IP addresses in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * Example 2:
 *
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * Example 3:
 *
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 20
 * s consists of digits only.
 *
 *
 *  List<String> res;
 *     public List<String> restoreIpAddresses(String s) {
 *         res = new ArrayList<>();
 *         if(s.length() < 4 || s.length() > 12) return res;
 *         backtrack(s, 0, 0, "");
 *         return res;
 *     }
 *
 *     public void backtrack(String s, int index, int cut, String curIp) {
 *         if(cut == 3 && index < s.length() && validSubnet(s.substring(index))) {
 *             curIp+=s.substring(index);
 *             res.add(curIp);
 *             return;
 *         }
 *         String cp = curIp;
 *         for(int i = index + 1; i<=index + 3 && i<=s.length(); i++) {
 *             String temp = s.substring(index, i);
 *             if(validSubnet(temp)) {
 *                 curIp+= temp + ".";
 *                 backtrack(s, i, cut+1, curIp);
 *                 curIp = cp;
 *             }
 *         }
 *     }
 *
 *     public boolean validSubnet(String val) {
 *         if(val.length() > 1 && val.charAt(0) == '0') return false;
 *         int value = Integer.parseInt(val);
 *         return value >=0 && value <=255;
 *     }
 *
 */


import java.util.*;
public class RestoreIPAddresses {

    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) return res;
        backtrack(s, 0, 0, "");
        return res;
    }

    public void backtrack(String s, int index, int cut, String subNet) {
        if(cut == 3 && isValidSubNet(s.substring(index))) {
            subNet += s.substring(index);
            res.add(subNet);
            return;
        }

        for(int i = 1; i<=3; i++) {
            if(index + i <= s.length() && isValidSubNet(s.substring(index, index + i))) {
                backtrack(s, index + i, cut + 1, subNet + s.substring(index, index + i) + ".");
            }
        }
    }

    public boolean isValidSubNet(String sub) {
        if(sub.length() == 0 || sub.length() > 3) return false;
        int val = Integer.valueOf(sub);
        if(val > 0 && sub.charAt(0) == '0') return false;
        if(val == 0 && sub.length() > 1) return false;
        if(val > 255) return false;
        return true;
    }

    public static void main(String ... args) {
        String test = "25525511135";
        String test1 = "0000";
        String test2 = "101023";
        String test3 = "0279245587303";
        RestoreIPAddresses r = new RestoreIPAddresses();
        System.out.println(r.restoreIpAddresses(test3));
    }
}
