/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord,
 * or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
 *
 *
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * Explanation: There are 2 shortest transformation sequences:
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: []
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *
 *
 * Constraints:
 *
 * 1 <= beginWord.length <= 5
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 1000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 */
import java.lang.reflect.GenericDeclaration;
import java.util.*;
public class WordLadderII {
    List<List<String>> res;
    Map<String, List<String>> dag;
    Set<String> wordSet;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        res =  new ArrayList<>();
        dag = new HashMap<>();
        wordSet = new HashSet<>(wordList);
        bfs(beginWord, endWord);
        System.out.println(dag);
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(beginWord, endWord, list);
        return res;
    }

    public List<String> getNeighbors(String word) {
        char [] chars = word.toCharArray();
        List<String> neighbors = new ArrayList<>();
        for(int i=0; i<chars.length; i++) {
            char copy = chars[i];
            for(char c = 'a'; c <='z'; c++) {
                chars[i] = c;
                String cur = String.valueOf(chars);
                if(!cur.equals(word)) {
                    neighbors.add(cur);
                }
            }
            chars[i] = copy;
        }
        return neighbors;
    }

    public void bfs(String beginWord, String endWord) {
        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet<>();
        Set<String> toVisit = new HashSet<>();
        queue.offer(beginWord);
        toVisit.add(beginWord);
        boolean isDes = false;
        while(!queue.isEmpty()) {
            visited.addAll(toVisit);
            toVisit.clear();
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String cur = queue.poll();
                List<String> neighbors = getNeighbors(cur);
                for(int j = 0; j<neighbors.size(); j++) {
                    String next = neighbors.get(j);
                    if(next.equals(endWord)) isDes = true;
                    if(!visited.contains(next) && wordSet.contains(next)) {
                        if(!dag.containsKey(cur)) {
                            dag.put(cur, new ArrayList<>());
                        }
                        dag.get(cur).add(next);
                        if(!visited.contains(next) && !toVisit.contains(next)) {
                            queue.offer(next);
                            toVisit.add(next);
                        }
                    }
                }
            }
            if(isDes) {
                break;
            }
        }
    }

    public void dfs(String beginWord, String endWord, List<String> list) {
        if(beginWord.equals(endWord)) {
            res.add(new ArrayList<>(list));
            return;
        }
        List<String> neighbors = dag.get(beginWord);
        if(neighbors == null || neighbors.size() ==0) return;
        for(int i=0; i<neighbors.size(); i++) {
            String next = neighbors.get(i);
            list.add(next);
            dfs(next, endWord, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String [] args) {
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        WordLadderII w = new WordLadderII();
        w.findLadders("hit", "cog", wordList);
    }
}
