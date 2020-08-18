package advanced;

import strings.Trie;
import strings.TrieNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given dictionary and character matrix, find all possible words that are in the dictionary
 * https://www.geeksforgeeks.org/boggle-set-2-using-trie/
 *
 * Solution: create trie of dictionary and only explore a path of a cell if it is the root in the trie. Collect
 * the words during exploration.
 */
public class WordBoggleTrie {

    public static void main(String[] args) {
        char[][] m = {
                {'T', 'T', 'S'},
                {'E', 'A', 'R'},
                {'T', 'O', 'N'}
        };

        Set<String> d = new HashSet<>(Arrays.asList("STAR", "NOTE", "SAND", "STONE"));
        boggle(d, m);
    }

    static void boggle(Set<String> d, char[][] m) {
        Trie t = new Trie();
        for (String s : d) {
            t.insert(s);
        }

        int[] rows = {-1, 0, 0, 1};
        int[] cols = {0, -1, 1, 0};
        Set<String> result = new HashSet<>();

        Map<Character, TrieNode> roots = t.getHead().getChildren();
        for (int row = 0; row < m.length; row++) {
            for (int column = 0; column < m[0].length; column++) {
                search(m, rows, cols, roots, row, column, result, "");
            }
        }

        for(String s : result)
            System.out.println(s);
    }

    static void search(char[][] m, int[] rows, int[] cols, Map<Character, TrieNode> roots, int i, int j, Set<
            String> result, String word) {
        char c = m[i][j];
        word += c;
        TrieNode node = roots.get(c);
        if (node != null) {
            if (node.isWord()) {
                result.add(word);
                return;
            }

            for (int k = 0; k < 4; k++) {
                int row = i + rows[k];
                int col = j + cols[k];

                if (row >= 0 && col >= 0 && row < m.length && col < m[0].length) {
                    search(m, rows, cols, node.getChildren(), row, col, result, word);
                }
            }
        }
    }
}
