package advanced;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.techiedelight.com/generate-list-of-possible-words-from-a-character-matrix/
 *
 * <p>Given M*N boggle board, find all possible words that can be formed by a sequence of adjacent
 * characters on the board.
 *
 * <p>Time: exponential
 */
public class WordBoggle {
  static void boggle(char[][] m, Set<String> d) {
    int[] rows = {-1, 0, 0, 1};
    int[] cols = {0, -1, 1, 0};

    Set<String> words = new HashSet<>();
    boolean[][] visited = new boolean[m.length][m[0].length];

    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        boggle(m, d, words, visited, i, j, rows, cols, "");
      }
    }

    System.out.println(words);
  }

  static void boggle(
      char[][] m,
      Set<String> d,
      Set<String> words,
      boolean[][] visited,
      int i,
      int j,
      int[] rows,
      int[] cols,
      String path) {
    visited[i][j] = true;
    path += m[i][j];

    //        System.out.println(path);
    if (d.contains(path)) words.add(path);

    for (int k = 0; k < 4; k++) {
      int row = i + rows[k];
      int col = j + cols[k];

      if (row >= 0 && row < m.length && col >= 0 && col < m[0].length && !visited[row][col]) {
        boggle(m, d, words, visited, row, col, rows, cols, path);
      }
    }

    visited[i][j] = false;
  }

  public static void main(String[] args) {
    char[][] m = {
      {'T', 'T', 'S'},
      {'E', 'A', 'R'},
      {'T', 'O', 'N'}
    };

    Set<String> d = new HashSet<>(Arrays.asList("STAR", "NOTE", "SAND", "STONE"));
    boggle(m, d);
  }
}
