package advanced;

/** Print all combinations of n pairs of balanced parantheses */
public class PairsOfBalancedParantheses {

  public static void main(String[] args) {
    int n, left, right;
    n = left = right = 3;
    print(left * 2, 0, left, right, new char[n * 2]);
  }

  public static void print(int n, int pos, int left, int right, char[] c) {

    if (right == n) {
      System.out.println(new String(c));
      return;
    }

    if (left > right) {
      c[pos] = ')';
      print(n, pos+1, left, right + 1, c);
    }

    if (left < n) {
      c[pos] ='(';
      print(n, pos+1, left+1, right, c);
    }

  }
}
