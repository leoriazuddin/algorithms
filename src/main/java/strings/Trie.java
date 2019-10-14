package strings;

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new Trie();
 *
 * obj.insert(word); boolean param_2 = obj.search(word); boolean param_3 = obj.startsWith(prefix);
 */
public class Trie {

    private TrieNode head = new TrieNode();

    /**
     * Initialize your data structure here.
     */
    public Trie() {
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode current = head;
        int i = 0;
        for (i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!current.children.containsKey(c)) {
                break;
            }
            current = current.children.get(c);
        }
        while (i < word.length()) {
            char c = word.charAt(i);
            current.children.put(c, new TrieNode());
            current = current.children.get(c);
            i++;
        }
        current.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode current = head;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return current.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode current = head;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return false;
    }
}
