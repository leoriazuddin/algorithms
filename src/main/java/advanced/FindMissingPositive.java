package advanced;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * https://www.youtube.com/watch?v=9SnkdYXNIzM
 * Problem: Return the first minimum positive missing number
 *
 * Solution:
 * 1.   if array does not have 1, return 1.
 * 2.   mark all a[i] = 1, such that a[i] <= 0 && a[i] > a.length.
 * 3.   negate elements at index of each element. if a[0] = 7, negate a[7 - 1]
 * 4.   return the first (index + 1) whose element is non negative
 * 5.   else return a.length + 1
 */
public class FindMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        boolean foundOne = false;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1)
                foundOne = true;
        }

        if(!foundOne)
            return 1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0 || nums[i] > nums.length)
                nums[i] = 1;
        }

        for(int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);
            if(nums[x - 1] > 0)
                nums[x - 1] = -nums[x - 1];
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                return i + 1;
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        FindMissingPositive run = new FindMissingPositive();
        int[] input = {1, 7, 10};
        System.out.println(run.firstMissingPositive(input));
    }
}