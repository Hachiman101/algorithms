package strings;

public class EditDistance {

    private static int match(char a, char b) {
        return (a == b) ? 0 : 1;
    }

    public static int editDistance(String s1, String s2) {
        int[][] d = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length() + 1; i++) {
            d[i][0] = i;
        }

        for (int i = 0; i < s2.length(); i++) {
            d[0][i] = i;
        }

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                int insertionCost = d[i][j - 1] + 1;
                int deletionCost = d[i - 1][j] + 1;
                int substitutionCost = d[i - 1][j - 1] + match(s1.charAt(i - 1), s2.charAt(j - 1));
                d[i][j] = Math.min(Math.min(insertionCost, deletionCost), substitutionCost);
            }
        }

        return d[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(editDistance("AAAA", "AAAB"));
        System.out.println(editDistance("occurred", "preferred"));
    }
}
