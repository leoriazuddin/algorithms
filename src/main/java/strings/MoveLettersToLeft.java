package strings;
/**
 * Move all alphabets to left and order should be preserved, all digits should be on right side and their
 * order is not important
 */
public class MoveLettersToLeft {

    public static char[] moveLetters(char[] a) {
        int ptc = 0, ptn = 0, l = a.length - 1;
        while (ptc <= l && ptn <= l) {
            // Find ptr to next char
            // while (Character.isAlphabetic(a[ptc]) && ptc <= l)
            while (a[ptn] < '0' && a[ptn] > '9' && ptc <= l) {
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
