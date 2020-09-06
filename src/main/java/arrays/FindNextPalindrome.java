package arrays;

/**
 *
 * http://www.ardendertat.com/2011/12/01/programming-interview-questions-19-find-next-palindrome-number/
 *
 * Given a number find the closest palindrome which is bigger than the number.
 *
 * <p>for odd length input - mirror digits on left to the right of the center, if number is less
 * than input increment center by 1 - if center is 9, round the left most digit to nearest 100s or
 * 1000s etc. and then mirror the left to right
 *
 * <p>even length input, process is same except that at center we will have two digits to increment.
 */
public class FindNextPalindrome {

  public static int nextPalindrome(int input) {
    String str = String.valueOf(input);

    if (isPalindrome(str)) return input;

    int len = str.length();
    boolean oddInput = len % 2 != 0;
    if (oddInput) {
      int mid = len / 2, center = Character.getNumericValue(str.charAt(mid));
      if (center == 9) {
        int intVal = Integer.parseInt(str);
        intVal += Math.pow(10, mid);
        String palindrome = copyOddLtoR(String.valueOf(intVal));
        return Integer.parseInt(palindrome);
      }

      str = copyOddLtoR(str);
      int result = Integer.parseInt(str);
      if (result < input) {
        result += Math.pow(10, mid);
      }

      return result;
    } else {
      int mid = (len / 2) - 1, center = Integer.parseInt(str.substring(mid, mid + 2));
      if (center == 99) {
        int intVal = Integer.parseInt(str);
        intVal += 11 + Math.pow(10, mid);
        String palindrome = copyEvenLtoR(String.valueOf(intVal));
        return Integer.parseInt(palindrome);
      }

      str = copyEvenLtoR(str);
      int result = Integer.parseInt(str);
      if (result < input) {
        result += 11 * Math.pow(10, mid);
      }

      return result;
    }
  }

  public static void main(String[] args) {
    System.out.println(nextPalindrome(379));
  }

  public static String copyEvenLtoR(String s) {
    int mid = s.length() / 2 - 1;
    char[] array = copyLtoR(s, mid);
    array[mid + 1] = array[mid];
    return new String(array);
  }

  private static char[] copyLtoR(String s, int mid) {
    int l = 0, r = s.length() - 1;
    char[] array = s.toCharArray();
    while (l < mid) {
      array[r] = array[l];

      l++;
      r--;
    }
    return array;
  }

  public static String copyOddLtoR(String s) {
    char[] array = copyLtoR(s, s.length() - 1 / 2);
    return new String(array);
  }

  public static boolean isPalindrome(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r) {
      if (s.charAt(l) != s.charAt(r)) return false;

      l++;
      r--;
    }

    return true;
  }
}
