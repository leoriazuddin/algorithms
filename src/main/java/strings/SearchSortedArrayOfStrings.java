package strings;

/**
 * Given an array of strings which can contain empty and non-empty strings. non-empty string are sorted.
 * Find index of given string.
 */
public class SearchSortedArrayOfStrings {

    public static void main(String[] args) {
        String[] input = {"for", "", "", "", "geeks", "ide", "", "practice", "", "monkey", "", "", "peacock", "quiz", "", "", "yak", "", "zebra", ""};
        System.out.println(search("yak", input));
    }

    /**
     * Use binary search, if empty string is found at an index, move left or right until
     * non-empty string is found and keep searching.
     *
     * @param search
     * @param strings
     * @return
     */
    private static int search(String search, String[] strings) {

        return search(search, strings, 0, strings.length - 1);
    }

    private static int search(String search, String[] strings, int start, int end) {
        System.out.println(String.format("Start %d End %d", start, end));
        if (start > end)
            return -1;

        while (start < end && strings[start].equals(""))
            start++;

        while (end > start && strings[end].equals(""))
            end--;

        if (strings[start].equals(search)) return start;
        if (strings[end].equals(search)) return end;

        int mid = (start + end) / 2;
        if (strings[mid].equals(search)) return mid;
        if (start == mid) return -1;

        int found = search(search, strings, start, mid);
        if (found == -1)
            return search(search, strings, mid + 1, end);

        return found;
    }
}
