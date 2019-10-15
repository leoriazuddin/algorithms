package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all possible neuronyms: L10n, is called a Neuronym of the word Localization
 *
 * for "nailed" : "n4d", "na3d", "nai2d", "na2ed", "n3ed", "n2led"
 */
public class Neuronyms {

    public static List<String> neuronym(String s) {
        int len = s.length() - 1, count = len - 1;
        List<String> result = new ArrayList<>();
        if (len < 3) {
            result.add(s);
        }

        while (count >= 2) {
            for (int i = 1; i <= len - count; i++) {
                result.add(s.substring(0, i) + count + s.substring(i + count));
            }
            count--;
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> al = neuronym("nailed");
        for (String s : al) {
            System.out.println(s);
        }

    }
}
