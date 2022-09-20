import java.util.*;
import java.util.function.Function;
import java.time.*;
import util.Util;
import warmup2.*;

public class Main {
    public static String[] randomAlphabeticalStrings(int numStrings, int length, double[] weights) {
        // Returns a String array `numStrings` long with each string being `length`
        // characters long
        // Each string consists of random alphabetical letters
        char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z', };

        String[] strs = new String[numStrings];
        for (int i = 0; i < numStrings; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; ++j) {
                // Appends a lowercase alphabetical letter
                sb.append(Util.randomChoice(letters, weights));
            }
            strs[i] = sb.toString();
        }
        return strs;
    }

    public static String[] randomAlphabeticalStrings(int numStrings, int length) {
        double[] weights = new double[26];
        Arrays.fill(weights, 1 / 26);
        return randomAlphabeticalStrings(numStrings, length, weights);
    }

    public static Duration timeAgainstStrings(String[] strs, Function<String, Object> func) {
        Instant start = Instant.now();
        for (String s : strs) {
            func.apply(s);
        }
        Instant end = Instant.now();
        return Duration.between(start, end);
    }

    public static void main(String[] args) {
        int numStrings = 1000;
        int length = 1_000_000;
        int n;
        if (args.length == 2) {
            n = Integer.valueOf(args[1]);
        } else {
            n = 100;
        }

        double xProb = 0.3;
        double[] weights = new double[26];
        Arrays.fill(weights, (1 - xProb) / 25);
        weights['x' - 'a'] = xProb;

        String[] strs = randomAlphabeticalStrings(numStrings, length, weights);

        Duration baselineElapsed = timeAgainstStrings(strs, s -> CountXX.countXXBaseline(s, n));
        System.out.printf("Baseline time: %f seconds\n", baselineElapsed.toMillis() / 1000.0);

        Duration modernElapsed = timeAgainstStrings(strs, s -> CountXX.countXX(s, n));
        System.out.printf("Modern time: %f seconds\n", modernElapsed.toMillis() / 1000.0);
    }
}
