package arrays;

public class ArrayHelper {

    public static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print("\t" + m[i][j]);
            }
            System.out.println();
        }
    }

    public static void printArray(int[] a) {
        for(int x : a)
            System.out.print(x+" ");

        System.out.println();
    }

    public static void printArray(int[] a, int low, int high) {
        for(int i = low; i <=high; i++)
            System.out.print(a[i]+" ");

        System.out.println();
    }
}
