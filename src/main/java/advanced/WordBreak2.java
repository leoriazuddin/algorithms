package advanced;

import java.util.*;

/**
 *
 */
public class WordBreak2 {

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        Set<String> dict = new HashSet<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        List<String> result = wordBreak2(s, dict, new HashMap<>());
        for(String subs : result) {
            System.out.println(subs);
        }
    }

    public static List<String> wordBreak2(String s, Set<String> d, Map<String, List<String>> map) {
        if(map.containsKey(s))
            return map.get(s);

        List<String> res = new ArrayList<>();
        if (s.length() == 0) { //Base case 2:
            res.add("");
            return res;
        }

        for(String word : d) {
            if(s.startsWith(word)) {
                List<String> l = wordBreak2(s.substring(word.length()), d, map);
                for (String sub : l) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }

        map.put(s, res);
        return res;
    }
}
