package arrays;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] m = {};
        print(m);
    }

    private static void print(int[][] m) {
        int left = 0, right = m[0].length, top = 0, bottom = m.length, row = 0, col = 0;

        while (left < right && top < bottom) {
            while (col < right) {
                System.out.print("\t" + m[row][col]);
                col++;
            }
            col--;
            top++;
            row++;
            System.out.println();

            while (row < bottom) {
                System.out.print("\t" + m[row][col]);
                row++;
            }
            row--;
            right--;
            col--;
            System.out.println();

            while (col >= left) {
                System.out.print("\t" + m[row][col]);
                col--;
            }
            col++;
            bottom--;
            row--;
            System.out.println();

            while (row >= top) {
                System.out.print("\t" + m[row][col]);
                row--;
            }
            row++;
            left--;
            col--;
            System.out.println();
        }
    }
}
