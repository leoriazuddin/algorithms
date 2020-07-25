package strings;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    boolean isWord;
    Map<Character, TrieNode> children = new HashMap<>();

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isWord() {
        return isWord;
    }
}
