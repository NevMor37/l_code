import java.util.*;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together.
 * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine,
 * which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 3
 * Output: "III"
 * Explanation: 3 is represented as 3 ones.
 * Example 2:
 *
 * Input: num = 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 3:
 *
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 *
 * Constraints:
 *
 * 1 <= num <= 3999
 * 1 2 3 4 5 6 7 8 9
 */
public class IntegerToRoman {

    public static String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        int [] arr = new int [4];
        int i = 3;
        while(num > 0) {
            int temp = num%10;
            arr[i--] = temp;
            num/=10;
        }
        StringBuilder sb = new StringBuilder();
        for(i=0; i<4; i++) {
            int val = arr[i];
            if(val == 0) continue;
            if(i == 0) {
                for(int j=0; j<val; j++) {
                    sb.append(map.get(1000));
                }
            } else if(i == 1) {
                if(val == 4) {
                    sb.append(map.get(100));
                    sb.append(map.get(500));
                } else if(val == 9) {
                    sb.append(map.get(100));
                    sb.append(map.get(1000));
                } else if(val < 4) {
                    for(int j=0; j<val; j++) {
                        sb.append(map.get(100));
                    }
                } else {
                    sb.append(map.get(500));
                    for(int j=0; j<val-5;j++) {
                        sb.append(map.get(100));
                    }
                }
            } else if(i ==2) {
                if(val == 4) {
                    sb.append(map.get(10));
                    sb.append(map.get(50));
                } else if(val == 9) {
                    sb.append(map.get(10));
                    sb.append(map.get(100));
                } else if(val < 4) {
                    for(int j=0; j<val; j++) {
                        sb.append(map.get(10));
                    }
                } else {
                    sb.append(map.get(50));
                    for(int j=0; j<val-5;j++) {
                        sb.append(map.get(10));
                    }
                }
            } else {
                if(val == 4) {
                    sb.append(map.get(1));
                    sb.append(map.get(5));
                } else if(val == 9) {
                    sb.append(map.get(1));
                    sb.append(map.get(10));
                } else if(val < 4) {
                    for(int j=0; j<val; j++) {
                        sb.append(map.get(1));
                    }
                } else {
                    sb.append(map.get(5));
                    for(int j=0; j<val-5;j++) {
                        sb.append(map.get(1));
                    }
                }
            }
        }
        return sb.toString();
    }

    public static String romanToStringOptimized(int num) {
        StringBuilder result = new StringBuilder();
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        int i = 0;
        while (num >0) {
            while ( num >= values[i]) {
                num -= values[i];
                result.append(roman[i]);
            }
            i++;
        }
        return result.toString();
    }
    public static void main(String [] args) {
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(3));
    }
}
