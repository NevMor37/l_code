/**
 * A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. The lengths should not have leading zeros.
 *
 * For example, a string such as "substitution" could be abbreviated as (but not limited to):
 *
 * "s10n" ("s ubstitutio n")
 * "sub4u4" ("sub stit u tion")
 * "12" ("substitution")
 * "su3i1u2on" ("su bst i t u ti on")
 * "substitution" (no substrings replaced)
 * The following are not valid abbreviations:
 *
 * "s55n" ("s ubsti tutio n", the replaced substrings are adjacent)
 * "s010n" (has leading zeros)
 * "s0ubstitution" (replaces an empty substring)
 * Given a string word and an abbreviation abbr, return whether the string matches the given abbreviation.
 *
 * A substring is a contiguous non-empty sequence of characters within a string.
 *
 *
 *
 * Example 1:
 *
 * Input: word = "internationalization", abbr = "i12iz4n"
 * Output: true
 * Explanation: The word "internationalization" can be abbreviated as "i12iz4n" ("i nternational iz atio n").
 * Example 2:
 *
 * Input: word = "apple", abbr = "a2e"
 * Output: false
 * Explanation: The word "apple" cannot be abbreviated as "a2e".
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 20
 * word consists of only lowercase English letters.
 * 1 <= abbr.length <= 10
 * abbr consists of lowercase English letters and digits.
 * All the integers in abbr will fit in a 32-bit integer.
 */
public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int start = 0, val = 0;
        for(char c : abbr.toCharArray()) {
            if(Character.isDigit(c)) {
                if(c == '0' && val == 0) return false;
                val = val * 10 + c - '0';
            } else {
                start += val;
                val = 0;
                if(start >= word.length() || word.charAt(start) != c) return false;
                start++;
            }
        }
        return start + val == word.length();
    }
    public static void main(String [] args) {
        String test = "internationalization";
        //String abbr = "i12iz4n";
        String abbr = "i5a11o1";
        ValidWordAbbreviation v = new ValidWordAbbreviation();
        System.out.println(v.validWordAbbreviation(test, abbr));
        String a="123";
        StringBuilder b = new StringBuilder("123");
        a+=false;
        System.out.println(a);
        System.out.println(b);
       // boolean value = a == b ?

        Check c = new Check();
        c.a = 1;
        c.b = 2;
        v.dosth(c);
        //copy 指向了同一个object并且修改了值
        //影响了原对象
        System.out.println(c.a + " " + c.b);
    }

    public boolean rewrite(String word, String abbr) {
        int start = 0, val=0;
        for(char a : abbr.toCharArray()) {
            if(Character.isDigit(a)) {
                if(a == '0' && val == 0) return false;
                val = val * 10 + a - '0';
            } else {
                start += val;
                val = 0;
                if(start >= word.length() || word.charAt(start) != a) {
                    return false;
                }
                start ++;
            }
        }
        return start + val == word.length();
    }

    public void dosth(Check c) {
        c.a = 3;
        c.b = 4;
    }
}

class Check {
    int a;
    int b;
}