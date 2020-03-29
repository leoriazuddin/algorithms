package arrays;

/**
 * Rotate matrix k times
 *
 * Rotate each submatrix k times.
 */
public class RotateMatrix {

    public static void main(String[] args) {

        int[][] m = {{12, 23, 34}, {45, 56, 67}, {78, 89, 91}};

        RotateMatrix main = new RotateMatrix();
        main.rotate(m, 2);
        ArrayHelper.printMatrix(m);
    }

    void rotate(int[][] m, int k) {
        for (int[] row : m) {
            rotate(row, k);
        }
    }

    void rotate(int[] m, int k) {

        for (int i = 0; i < k; i++) {
            int temp = m[m.length - 1];
            for (int j = m.length - 1; j > 0; j--) {
                m[j] = m[j - 1];
            }

            m[0] = temp;
        }
    }
}
