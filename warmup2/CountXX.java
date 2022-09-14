package warmup2;

public class CountXX {
    public static int countXXBaseline(String str, int numXs) {
        int count = 0;
        String cmpStr = "x".repeat(numXs);
        for (int i = 0; i < str.length() - numXs + 1; ++i) {
            if (str.substring(i, i + numXs).equals(cmpStr)) {
                ++count;
            }
        }
        return count;
    }

    public static int countXXBaseline(String str) {
        return countXXBaseline(str, 2);
    }

    public static int countXX(String str, int numXs) {
        int count = 0;
        for (int i = 0; i < str.length() - numXs + 1; ++i) {
            // Save the current position
            int oldI = i;
            // Keep incrementing position while str.charAt(i) == 'x'
            for (; i < str.length() && str.charAt(i) == 'x'; ++i); 
            // Increment count by how many positions past numXs we got to
            // So if numXs == 2, oldI = 4, and i = 6, then including overlaps
            // we have 6 - 4 - 2 + 1 = 1 XX string of length two
            // The + 1 is to offset the fact that, say, 6 - 4 == 2, but with numXs == 2,
            // that would make for 0 additional XX strings, which isn't the case.
            count += Math.max(i - oldI - numXs + 1, 0);
        }
        return count;
    }

    public static int countXX(String str) {
        return countXX(str, 2);
    }
}
