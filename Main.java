import java.util.*;
import java.util.function.Function;
import java.time.*;
import warmup2.*;

public class Main {
    public static Duration timeRandomAlphabeticalString(int iters, int length, Function<String, Object> func) {
        // Returns how long it takes to run a function `func` : String -> Object on a
        // random string `length` long `iters` times, consisting of only lowercase letters

        Instant start = Instant.now();

        // Building string
        for (int c = 0; c < iters; ++c) {
            StringBuilder sb = new StringBuilder();
            Random rng = new Random();
            for (int i = 0; i < length; ++i) {
                // Appends a lowercase alphabetical letter
                sb.append((char) (rng.nextInt(26) + 97));
            }
            String s = sb.toString();
            // Performs the function on the random string
            func.apply(s);
        }

        Instant end = Instant.now();
        Duration elapsed = Duration.between(start, end);
        return elapsed;
    }

    public static void main(String[] args) {
        int iters = 1000;
        int length = 1_000_000;

        Duration baselineElapsed = timeRandomAlphabeticalString(iters, length, s -> CountXX.countXXBaseline(s));
        System.out.printf("Baseline time: %f seconds\n", baselineElapsed.toMillis() / 1000.0);

        Duration modernElapsed = timeRandomAlphabeticalString(iters, length, s -> CountXX.countXX(s));
        System.out.printf("Modern time: %f seconds\n", modernElapsed.toMillis() / 1000.0);
    }
}
