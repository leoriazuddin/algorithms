package strings;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    boolean isWord;
    Map<Character, TrieNode> children = new HashMap<>();
}
