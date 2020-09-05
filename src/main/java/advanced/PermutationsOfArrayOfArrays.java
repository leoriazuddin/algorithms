package advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given array of arrays, return list of arrays where each array consist of at most 1 element from
 * each array.
 */
public class PermutationsOfArrayOfArrays {
  public static void main(String[] args) {
    int[][] input = {{1, 2, 6}, {2, 4}, {3, 5}};
    permutation(input);
  }

  public static void permutation(int[][] input) {

    List<int[]> result = new ArrayList<>();
    int length = input.length;

    permutation(input, length, result, null, 0);
    printOutput(result);
  }

  private static void printOutput(List<int[]> result) {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    for(int[] a : result) {
      sb.append("{");
      for(int i : a) {
        sb.append(i+", ");
      }
      sb.delete(sb.lastIndexOf(","), sb.length());
      sb.append("}").append(" ,");
    }
    sb.delete(sb.lastIndexOf(","), sb.length());
    sb.append("}");
    System.out.println(sb.toString());
  }

  public static void permutation(int[][] input, int length, List<int[]> result, int[] newArray, int index) {
    if (index == input.length) {
      result.add(newArray);
      return;
    }

    int[] a = input[index];
    if (newArray == null)
      newArray = new int[length];

    for (int i = 0; i < a.length; i++) {
      newArray[index] = a[i];
      permutation(input, length, result, newArray, index + 1);
      newArray = Arrays.copyOf(newArray, length);
    }
  }
}
