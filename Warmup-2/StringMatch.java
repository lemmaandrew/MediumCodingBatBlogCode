public class StringMatch {
    public int StringMatchBaseline(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length() - 1 && i < b.length() - 1; ++i) {
            if (a.substring(i, i + 2).equals(b.substring(i, i + 2))) {
                ++count;
            }
        }
        return count;
    }

    public int stringMatch(String a, String b) {
        int count = 0;
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len - 1; ++i) {
            int oldI = i;
            for (; i < len && a.charAt(i) == b.charAt(i); ++i);
            count += Math.max(i - oldI - 1, 0);
        }
        return count;
    }
}
