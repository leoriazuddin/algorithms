package arrays;

import java.util.ArrayList;
import java.util.List;

/** Find the next greater number with same digits.
 *
 * Approach:
 *  add digits to list (this gives rightmost element at index 0)
 *  if no digit is greater than the leftmost digit then return.
 *
 *  from right (idx=0), pick 'max' and optionally 'min' such that min is to the right of max.
 *  for example, in 350, max=5, min=0
 *  in 135, max=5 and there is no min.
 *
 *  from 'max' move towards left and find the first digit smaller than max, swap them
 *  in 350, swap 3 and 5 to give 530
 *
 *  finally swap the new number with 'min'
 *  so from 530, we have 503
 *
 *  i.e. next greater of 350 is 503
 *
 * */
public class NextGreaterNumber {

  public static void nextGreater(int input) {
    int num = input;
    List<Integer> list = new ArrayList<>();
    while (num > 0) {
      list.add(num % 10);
      num /= 10;
    }
    int len = list.size() - 1;
    int left = list.get(len);
    boolean valid = false;
    for (int i = len; i >= 0; i--) {
      if (left < list.get(i)) {
        valid = true;
        break;
      }
    }
    if (!valid) {
      System.out.println(input + " --> " + input);
      return;
    }

    // find the min from right and also number which has all numbers less than it on its right
    int min = list.get(0), max = list.get(0), minIdx = 0, maxIdx = 0;
    for (int i = 1; i < list.size(); i++) {
      int val = list.get(i);

      if (val > max) {
        max = val;
        maxIdx = i;
        break;
      }

      if (val < min) {
        min = val;
        minIdx = i;
      }
    }

    for (int i = maxIdx + 1; i < list.size(); i++) {
      if (list.get(i) < max) {
        swap(list, i, maxIdx);
        if (maxIdx > minIdx && list.get(maxIdx) > minIdx) {
          swap(list, maxIdx, minIdx);
        }
        break;
      }
    }

    System.out.println(input + " --> " + toNumber(list));
  }

  public static int toNumber(List<Integer> list) {
    int num = 0, base = 10;
    for (int i = list.size() - 1; i >= 0; i--) {
      num *= base;
      num += list.get(i);
    }

    return num;
  }

  public static void swap(List<Integer> list, int from, int to) {
    int temp = list.get(from);
    list.set(from, list.get(to));
    list.set(to, temp);
  }

  public static void main(String[] args) {
    nextGreater(438993);
    nextGreater(150);
    nextGreater(158);
    nextGreater(35);
    nextGreater(15);
    nextGreater(5);
    nextGreater(502);
    nextGreater(398);
  }
}
