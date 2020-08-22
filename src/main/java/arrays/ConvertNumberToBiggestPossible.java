package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConvertNumberToBiggestPossible {

  public static void biggest(int num) {
    List<Integer> list = new ArrayList<>();
    while (num > 0) {
      list.add(num % 10);
      num /= 10;
    }

    Collections.sort(list, Collections.reverseOrder());
    toNumber(list);
  }

  public static void toNumber(List<Integer> array) {
    int num = 0, base = 10;
    for (Integer i : array) {
      num *= base;
      num += i;
    }

    System.out.println(num);
  }

  public static void main(String[] args) {
    biggest(398932342);
  }
}
