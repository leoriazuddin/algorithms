package strings;

/**
 * https://leetcode.com/problems/basic-calculator-ii/description/
 *
 * Build char array
 */
public class BasicCalculator {

    public int calc(String in) {

        int mul_div = -1; // * = 0, / = 1
        int sign = 1; // 1 is +, -1 is -
        int prev = 0;
        int result = 0;

        char[] chars = in.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int num = c - '0';
            if (Character.isDigit(c)) {
                while ((i+1) < chars.length && Character.isDigit(chars[i+1])) {
                    num = num * 10 + chars[++i] - '0';
                }

                if (mul_div == 0) {
                    prev = prev * num;
                    mul_div = -1;
                } else if (mul_div == 1) {
                    prev = prev / num;
                    mul_div = -1;
                } else {
                    prev = num;
                }
            } else if (c == '+') {
                result += prev * sign;
                sign = 1;
            } else if (c == '-') {
                result += prev * sign;
                sign = -1;
            } else if (c == '*') {
                mul_div = 0;
            } else if (c == '/') {
                mul_div = 1;
            }
        }

        result += prev * sign;
        return result;
    }

    public static void main(String[] args) {
        BasicCalculator c = new BasicCalculator();
        System.out.println(c.calc("3*2*2"));
    }
}
