package arrays;

public class SpiralMatrix {

    /*
        Print matrix spirally
        XY
        MB ==> XYBM
     */
    public static void main(String[] args) {
        char[][] m = {{'X', 'Y'}, {'M', 'B'}};
        //char[][] m = {{'X', 'Y', 'A'}, {'M', 'B', 'C'}};
        //char[][] m = {{'X', 'Y', 'A'}, {'M', 'B', 'C'}, {'P', 'Q', 'R'}};
        printSpiral(m);
    }

    static void printSpiral(char[][] m) {
        int i = 0, j = 0, left = 0, top = 0, right = m[0].length, bottom = m.length;

        while (left < right && top < bottom) {
            //System.out.println(String.format("(%d,%d,%d,%d)", left, right, top, bottom));
            //increment j i.e. print left to right
            while (j < right) {
                System.out.print(m[i][j] + " ");
                //System.out.print(String.format("%s(%d,%d) ", m[i][j], i, j));
                j++;
            }
            j--;
            i++;
            top++;

            //increment i, print top to bottom
            while (i < bottom) {
                System.out.print(m[i][j] + " ");
                //System.out.print(String.format("%s(%d,%d) ", m[i][j], i, j));
                i++;
            }
            i--;
            j--;
            right--;

            //decrement j, print right to left
            while (j >= left) {
                System.out.print(m[i][j] + " ");
                //System.out.print(String.format("%s(%d,%d) ", m[i][j], i, j));
                j--;
            }
            j++;
            i--;
            bottom--;

            //decrement i, print bottom to top
            while (i >= top) {
                System.out.print(m[i][j] + " ");
                //System.out.print(String.format("%s(%d,%d) ", m[i][j], i, j));
                i--;
            }
            i++;
            j++;
            left++;
        }

        System.out.println();
    }
}