package strings;

/**
 * You're given a character array, which may contain alphabet letters (a to z or A to Z) as well as numbers (0 to 9,
 * represented as characters), in random order. You have to make alphabet letters appear on left side, inside the same
 * array. e.g. If your input is [0,a,1,9,3,z,b,r,6], then in your output, letters a, z, b, and r, should be seen on left
 * side in the array.
 *
 * Keep char (ptc) and number (ptn) pointer
 * increment ptc until number is found, increment ptn until char is found.
 * if ptn > ptc, swap their values
 */
public class MoveLettersToLeft {

    public static char[] moveLetters(char[] a) {
        int ptc = 0, ptn = 0, l = a.length - 1;
        while (ptc <= l && ptn <= l) {
            // Find ptr to next char
            // while (Character.isAlphabetic(a[ptc]) && ptc <= l)
            while ((a[ptc] < '0' || a[ptc] > '9') && ptc <= l) {
                //Important: the above is an 'or' condition'
                ptc++;
            }
            // Find ptr to next number
            // or while (Character.isDigit(a[ptn]) && ptn < l) {
            while (a[ptn] >= '0' && a[ptn] <= '9' && ptn < l) {
                //Important: the above is an 'and' condition'
                ptn++;
            }
            if (ptn > ptc) {
                swap(a, ptn, ptc);
                ptc++;
            }
            ptn++;
        }
        return a;
    }

    private static void swap(char[] a, int ptn, int ptc) {
        char tmp = a[ptn];
        System.out.println("Swapping " + a[ptn] + " and " + a[ptc]);
        a[ptn] = a[ptc];
        a[ptc] = tmp;
    }

    public static void main(String[] args) {
        //String s = "0a193zbr6";
        String s = "5azbr7l89k0p";
        char[] a = s.toCharArray();
        char[] b = moveLetters(a);
        for (char c : b) {
            System.out.print(c);
        }
    }
}
