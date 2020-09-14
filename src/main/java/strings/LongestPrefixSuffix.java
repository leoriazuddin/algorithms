package strings;

/** find length of longest prefix which is also suffix and they dont overlap
 *
 * Solution: start from mid, check chars at start and mid, reset start if they are not equal.
 *
 * */
public class LongestPrefixSuffix {
  public static void main(String[] args) {
    longestPrefix("hsbathroombaths");
  }

  static void longestPrefix(String s) {
    int start = 0, len = s.length(), mid = len / 2;

    while (mid < len) {
      start = s.charAt(start) == s.charAt(mid) ? start + 1 : 0;
      mid++;
    }

    System.out.println(start);
  }
}
