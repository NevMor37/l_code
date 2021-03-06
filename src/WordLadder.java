/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord,
 * or 0 if no such sequence exists.
 *
 *
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *
 *
 * Constraints:
 *
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 */
import java.util.*;
public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        if (!wordList.contains(endWord)) return 0;
        HashSet<String> set = new HashSet<>(wordList);
        visited.add(beginWord);
        queue.offer(beginWord);
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for(int i=0; i<size; i++) {
                String cur = queue.poll();
                if(cur.equals(endWord)) return step;
                char [] chars = cur.toCharArray();
                for(int j = 0; j<chars.length; j++) {
                    char temp = chars[j];
                    for(char k = 'a'; k<='z'; k++) {
                        if(k != chars[j]) {
                            chars[j] = k;
                            String next = new String(chars);
                            if(!visited.contains(next) && set.contains(next)) {
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                    chars[j] = temp;
                }
            }
        }
        return 0;
    }

    public static void main(String ... args) {
        String [] test = {"hot","dot","dog","lot","log","cog"};
        String [] test1= {"hot","dot","dog","lot","log"};
        List<String> list = Arrays.asList(test1);
        System.out.println(ladderLength("hit", "cog", list));
    }
}
