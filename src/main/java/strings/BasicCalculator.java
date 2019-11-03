package strings;

/**
 * https://leetcode.com/problems/basic-calculator-ii/description/
 */
public class BasicCalculator {

    public int calc(String in) {

        int md = -1; // * = 0, / = 1
        int sign = -1; // 1 is +, -1 is -
        int prev = 0;
        int result = 0;

        char[] chars = in.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int num = c - '0';
            if (Character.isDigit(c)) {
                while (++i < chars.length && Character.isDigit(chars[++i])) {
                    num = num * 10 + chars[i] - '0';
                }
                i--;

                if (md == 0) {
                    prev = prev * num;
                    md = -1;
                } else if (md == 1) {
                    prev = prev / num;
                    md = -1;
                } else {
                    prev = num;
                }
            } else if (c == '+') {
                result = result + prev * sign;
                sign = 1;
            } else if (c == '-') {
                result = result + prev * sign;
                sign = -1;
            } else if (c == '*') {
                md = 0;
            } else if (c == '/') {
                md = 1;
            }
        }

        result = result + sign * prev;
        return result;
    }
}
