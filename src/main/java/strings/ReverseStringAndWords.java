package strings;

/*
 * An arbitrary string like "This is fine" is given.
 * (1)  Write a method that reverses the characters in the string
 *      In the example the string with reversed characters would be "enif si sihT"
 *      Constraint: You are only allowed to use scalar helper variables like int i or char c
 * (2)  Write a method that reverses the words in the string
 *      In the example the string with reserved words would be "fine is This"
 */

public class ReverseStringAndWords {

  public static String reverseWords(String input) {
    String reversed = reverse(input);
    int start = 0, end = 0;

    char[] reversedArray = reversed.toCharArray();
    while (end <= input.length()) {

      if (end == input.length() || reversedArray[end] == ' ') {
        reverseArray(reversedArray, start, end - 1);
        start = end + 1;
      }
      end++;
    }

    return new String(reversedArray);
  }

  private static void reverseArray(char[] array, int start, int end) {
    while (start < end) {
      char temp = array[start];
      array[start] = array[end];
      array[end] = temp;

      start++;
      end--;
    }
    ;
  }

  public static String reverse(String input) {

    if (input == null || input.length() == 0) return input;

    char[] array = input.toCharArray();

    reverseArray(array, 0, input.length() - 1);

    return new String(array);
  }

  public static void main(String[] args) {
    String input = "This is fine";
    System.out.println(reverse(input));
    System.out.println(reverseWords(input));
  }
}
