import java.util.*;

public class KMP {
    public static int[] prefixFunction(String s) {
        int[] pi = new int[s.length()];
        int k = 0;
        for (int i = 1; i < s.length(); i++) {
            while (k > 0 && s.charAt(k) != s.charAt(i))
                k = pi[k - 1];
            if (s.charAt(k) == s.charAt(i)) k++;
            pi[i] = k;
        }
        return pi;
    }
    public static List<Integer> search(String text, String pattern) {
        List<Integer> positions = new ArrayList<>();
        if (pattern.isEmpty() || text.isEmpty()) return positions;

        int[] pi = prefixFunction(pattern);
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j))
                j = pi[j - 1];
            if (text.charAt(i) == pattern.charAt(j)) j++;
            if (j == pattern.length()) {
                positions.add(i - j + 1);
                j = pi[j - 1];
            }
        }
        return positions;
    }
}
