/**
 * Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails
 * of the account.
 *
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name,
 * they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts
 * themselves can be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * Explanation:
 * The first and second John's are the same person as they have the common email "johnsmith@mail.com".
 * The third John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * Example 2:
 *
 * Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"]
 * ,["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
 * Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"]
 * ,["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 *
 *
 * Constraints:
 *
 * 1 <= accounts.length <= 1000
 * 2 <= accounts[i].length <= 10
 * 1 <= accounts[i][j] <= 30
 * accounts[i][0] consists of English letters.
 * accounts[i][j] (for j > 0) is a valid email.
 */

//build graph by adjacent list
//use set to avoid duplicated node
//dfs each node and keep a visited set to retrieve nodes from same graph
//sort the subans and added to result
import java.util.*;
public class AccountsMerge {
    Map<String, Set<String>> graph;
    Set<String> visited;
    Map<String, String> emailToName;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if(accounts == null || accounts.size() == 0) return res;
        graph = new HashMap<>();
        visited = new HashSet<>();
        emailToName = new HashMap<>();
        buildGraph(accounts);

        for(String mail : emailToName.keySet()) {
            if(visited.add(mail)) {
                List<String> list = new ArrayList<>();
                list.add(mail);
                for(String nei : graph.get(mail)) {
                    if(!visited.contains(nei)) dfs(nei, list);
                }
                Collections.sort(list);
                list.add(0, emailToName.get(mail));
                res.add(list);
            }
        }
        return res;
    }

    public void buildGraph(List<List<String>> accounts) {
        for(List<String> account : accounts) {
            String name = account.get(0);
            for(int i=1; i<account.size(); i++) {
                String mail = account.get(i);
                graph.putIfAbsent(mail, new HashSet<>());
                emailToName.put(mail, name);

                if(i == 1) continue;
                String prev = account.get(i-1);
                graph.get(mail).add(prev);
                graph.get(prev).add(mail);
            }
        }
    }

    public void dfs(String node, List<String> list) {
        visited.add(node);
        list.add(node);
        Set<String> subSet = graph.get(node);
        for(String nei : subSet) {
            if(!visited.contains(nei)) {
                dfs(nei, list);
            }
        }
    }
}
