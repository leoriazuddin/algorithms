package advanced;

/** Print all combinations of n pairs of balanced parantheses */
public class PairsOfBalancedParantheses {

  public static void main(String[] args) {
    int n, left, right;
    n = left = right = 3;
    print(left * 2, 0, left, right, new char[n * 2]);
  }

  public static void print(int totalChars, int pos, int left, int right, char[] c) {

    if (right == totalChars) {
      System.out.println(new String(c));
      return;
    }

    if (left > right) {
      c[pos] = ')';
      System.out.println(String.format("Test: %s (l > r, pos: %d, left: %d, right: %d)", new String(c), pos, left, right));
      print(totalChars, pos+1, left, right + 1, c);
    }

    if (left < totalChars) {
      c[pos] ='(';
      System.out.println(String.format("Test: %s (l < t, pos: %d, left: %d, right: %d)", new String(c), pos, left, right));
      print(totalChars, pos+1, left+1, right, c);
    }
  }
}
