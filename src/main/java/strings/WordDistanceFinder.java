package strings;

/* This class will be given a list of words (such as might be tokenized
 * from a paragraph of text), and will provide a method that takes two
 * words and returns the shortest distance (in words) between those two
 * words in the provided text.
 * Example:
 *   WordDistanceFinder finder =
         new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
 *   assert(finder.distance("fox","the") == 3);
 *   assert(finder.distance("quick", "fox") == 1);
 *
 * "quick" appears twice in the input. There are two possible distance values for "quick" and "fox":
 *     (3 - 1) = 2 and (4 - 3) = 1.
 * Since we have to return the shortest distance between the two words we return 1.
 */


import java.util.List;

// ("fox", "quick", "brown", "the", "quick")
public class WordDistanceFinder {

    private List<String> words = null;

    public WordDistanceFinder(List<String> words) {
        this.words = words;
    }

    public int distance(String wordOne, String wordTwo) {

        if (words == null || words.size() == 0)
            return -1;
        if (wordOne == null || wordOne.trim().length() == 0)
            return -1;
        if (wordTwo == null || wordTwo.trim().length() == 0)
            return -1;

        int wordOneIdx = -1;
        int wordTwoIdx = -1;

        int distance = -1;
        for (String word : words) {
            if (word.equals(wordOne)) {
                wordOneIdx = words.indexOf(word);
            }

            if (word.equals(wordTwo)) {
                wordTwoIdx = words.indexOf(word);
            }

            if (wordOneIdx != -1 || wordTwoIdx != -1) {
                int newDistance = Math.abs(wordOneIdx - wordTwoIdx);
                if (distance == -1)
                    distance = newDistance;

                if (newDistance < distance)
                    distance = newDistance;
            }
        }

        if (wordOneIdx == -1 || wordTwoIdx == -1)
            return -1; // word not found

        return distance;
    }
}
