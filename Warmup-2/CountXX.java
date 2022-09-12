public class CountXX {
    public int countXXBaseline(String str, int numX) {
        int count = 0;
        String cmpStr = "x".repeat(numX);
        for (int i = 0; i < str.length() - numX + 1; ++i) {
            if (str.substring(i, i + numX).equals(cmpStr)) {
                ++count;
            }
        }
        return count;
    }

    public int countXXBaseline(String str) {
        return countXXBaseline(str, 2);
    }

    public int countXX(String str, int numX) {
        int count = 0;
        for (int i = 0; i < str.length() - numX + 1; ++i) {
            int oldI = i;
            for (; i < str.length() && str.charAt(i) == 'x'; ++i); 
            count += Math.max(i - oldI - numX + 1, 0);
        }
        return count;
    }

    public int countXX(String str) {
        return countXX(str, 2);
    }
}
