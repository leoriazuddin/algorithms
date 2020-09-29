package advanced;

import java.util.*;

/**
 * https://leetcode.com/problems/alien-dictionary/
 * https://www.youtube.com/watch?v=LA0X_N-dEsg
 *
 * Given list of words from alien dictionary where words are sorted lexicographically by rules of that language.
 * Derive order of letters in this language.
 *
 * Solution: Create a graph g, array to track incoming edges of each alphabet and print the nodes.
 *  Begin by printing from the root in BFS.
 *
 * Graph creation:
 *  Initialize graph: create map, iterate through the words and add all chars to the map with empty set as value.
 *  Build incoming edges: iterate words again, to compare words next to each other until the end.
 *      if the characters do not match, this means char_of_string1 comes before char_of_string2.
 *          Do iff not already added: map.get(char_of_string1).add(char_of_string2)
 *          increment incoming edge of char_of_string2
 *
 * Print in order: BFS
 *  Create a queue for BFS
 *  1.  Find the root: Iterate through graph keys,
 *          a. if incoming edge == 0. Add char to output string and also to q. This covers the first level in graph.
 *  2.  Iterate through the chars in queue.
 *          remove char from queue
 *          iterate through the neighbors of this char and decrement edges by 1.
 *          if edges == 0, add to output and also to q.
 *  3. return output.
 */
public class AlienLanguage {

    public static void main(String[] args) {
        AlienLanguage app = new AlienLanguage();
        String[] input = new String[]{"z", "x", "z"};
//        String[] input = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println("Order of words: "+ app.alienOrder(input));
    }

    public String alienOrder(String[] words) {
        // incoming edges for graph nodes
        int[] indegree = new int[26];
        Map<Character, Set<Character>> g = new HashMap<>();
        buildGraph(g, words, indegree);
        return bfs(g, indegree);
    }

    private void buildGraph(Map<Character, Set<Character>> g, String[] words, int[] indegree)
    {
        for(String word : words) {
            for (char c : word.toCharArray()) {
                g.putIfAbsent(c, new HashSet<>());
            }
        }

        for(int i = 1; i < words.length; i++) {
            String first = words[i - 1], second = words[i];
            int len = Math.min(first.length(), second.length());

            for(int j = 0; j < len; j++) {
                if(first.charAt(j) != second.charAt(j)) {
                    char out = first.charAt(j);
                    char in = second.charAt(j);

                    if(!g.get(out).contains(in)) {
                        g.get(out).add(in);
                        indegree[in - 'a']++;
                    }

//                    break;
                }
            }
        }
    }

    private String bfs(Map<Character, Set<Character>> g, int[] indegree) {
        StringBuilder sb = new StringBuilder();
        int totalChars = g.size();
        Queue<Character> q = new LinkedList<>();
        for(char c : g.keySet()) {
            if (indegree[c - 'a'] == 0) {
                sb.append(c);
                q.offer(c);
            }
        }

         while(!q.isEmpty()) {
             char curr = q.poll();
             Set<Character> neighbors = g.get(curr);
             if(neighbors == null || neighbors.size() == 0) continue;

             for(char neigh : neighbors) {
                 indegree[neigh - 'a']--;
                 if(indegree[neigh - 'a'] == 0) {
                     sb.append(neigh);
                     q.offer(neigh);
                 }
             }
         }

         return sb.toString();
    }
}
