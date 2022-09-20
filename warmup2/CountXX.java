package warmup2;

public class CountXX {
    public static int countXXBaseline(String str, int numXs) {
        int count = 0;
        int j;
        for (int i = 0; i < str.length() - numXs + 1; ++i) {
            for (j = 0; j < numXs && i + j < str.length() && str.charAt(i + j) == 'x'; ++j);
            if (j == numXs) {
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
        int j;
        for (int i = 0; i < str.length() - numXs + 1; ++i) {
            if (str.charAt(i) != 'x') {
                continue;
            }
            for (j = 0; j < numXs && i + j < str.length() && str.charAt(i + j) == 'x'; ++j);
            if (j == numXs) {
                --j;
                for (; i + j < str.length() && str.charAt(i + j) == 'x'; ++j) {
                    ++count;
                }
            }
            i += j;
        }
        return count;
    }

    public static int countXX(String str) {
        return countXX(str, 2);
    }
}
