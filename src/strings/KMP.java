package strings;

import java.util.ArrayList;
import java.util.List;

public class KMP {

    private static int[] prefixFunction(String s) {
        int[] prefixFunc = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            int j = prefixFunc[i - 1];

            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = prefixFunc[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            prefixFunc[i] = j;
        }

        return prefixFunc;
    }

    public static List<Integer> search(String text, String pattern) {
        int[] prefixFunc = prefixFunction(pattern);
        ArrayList<Integer> occurrences = new ArrayList<>();
        int j = 0;

        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = prefixFunc[j - 1];
            }

            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }

            if (j == pattern.length()) {
                occurrences.add(i - j + 1);
                j = prefixFunc[j - 1];
            }
        }

        return occurrences;
    }

    public static void main(String[] args) {
        List<Integer> occurrences = search("ABCABBACAB", "CAB");
        System.out.println(occurrences);
    }
}
