package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RabinKarp {

    private static long charToLong(char c) {
        return c - 'A' + 1;
    }

    public static List<Integer> search(String text, String pattern) {
        int a = 101;
        long m = 1000000000;

        long patternHash = 0;
        long currentSubstrHash = 0;
        long pow = 1;

        for (int i = 0; i < pattern.length(); i++) {
            patternHash += charToLong(pattern.charAt(i)) * pow;
            patternHash %= m;

            currentSubstrHash += charToLong(text.charAt(text.length() - pattern.length() + i)) * pow;
            currentSubstrHash %= m;

            if (i != pattern.length() - 1) {
                pow = pow * a % m;
            }
        }

        ArrayList<Integer> occurrences = new ArrayList<>();

        for (int i = text.length(); i >= pattern.length(); i--) {
            if (patternHash == currentSubstrHash) {
                boolean found = true;

                for (int j = 0; j < pattern.length(); j++) {
                    if (text.charAt(i - pattern.length() + j) != pattern.charAt(j)) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    occurrences.add(i - pattern.length());
                }
            }

            if (i > pattern.length()) {
                currentSubstrHash = (currentSubstrHash - charToLong(text.charAt(i - 1)) * pow % m + m) * a % m;
                currentSubstrHash = (currentSubstrHash + charToLong(text.charAt(i - pattern.length() - 1))) % m;
            }
        }

        Collections.reverse(occurrences);
        return occurrences;
    }

    public static void main(String[] args) {
        List<Integer> occurrences = search("ABCABBACAB", "CAB");
        System.out.println(occurrences);
    }
}
