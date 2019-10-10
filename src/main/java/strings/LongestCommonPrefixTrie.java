package strings;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefixTrie {

    public static void main(String... args) {
        LongestCommonPrefixTrie run = new LongestCommonPrefixTrie();
        String lcp = run.longestCommonPrefix("ADOBE", "ADORE", "ADOLF", "ADDRESS");
        System.out.println(String.format("Longest Common Prefix: %s", lcp));
    }

    String longestCommonPrefix(String... strs) {

        TrieNode head = new TrieNode();
        buildTrie(head, strs);
        return lcp(head);
    }

    private void buildTrie(TrieNode head, String... strs) {

        for (String s : strs) {
            TrieNode current = head;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!current.children.containsKey(c))
                    current.children.put(c, new TrieNode());

                current = current.children.get(c);
            }
            current.leaf = true;
        }
    }

    private String lcp(TrieNode current) {
        StringBuilder sb = new StringBuilder();
        while (current.children.size() == 1) {
            for (Map.Entry<Character, TrieNode> e : current.children.entrySet()) {
                sb.append(e.getKey());
                current = e.getValue();
            }
        }

        return sb.toString();
    }

    static class TrieNode {
        boolean leaf;
        private Map<Character, TrieNode> children = new HashMap<>();
    }
}
