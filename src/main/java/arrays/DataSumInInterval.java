package arrays;

/**
 * Data is coming every minute. Get sum of last 5 minutes of data.
 */
public class DataSumInInterval {

    private int[] data = new int[5];
    private int idx = 0;

    public void sum(int[] in) {
        int sum = 0;
        for (int i : in) {
            sum += i;
        }

        data[idx++] = sum;

        idx %= 5;

        for(int i = 0 ; i < data.length; i++) {
            System.out.print(String.format("%s:%s ", i, data[i]));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DataSumInInterval main = new DataSumInInterval();
        main.sum(new int[]{1, 2, 3});
        main.sum(new int[]{0, 5, 1});
        main.sum(new int[]{2, 3, -1});
        main.sum(new int[]{4, 2, 0});
        main.sum(new int[]{1, -1, 3});
        main.sum(new int[]{1, 4, 3});
        main.sum(new int[]{0, 2, 3});
        main.sum(new int[]{1, 2, 1});
    }
}
