package util;

import java.util.*;

public class Util {
    public static char randomChoice(char[] objs, double[] weights) {
        double totalWeight = 0.0;
        for (double w : weights) {
            totalWeight += w;
        }

        int i = 0;
        for (double currentWeight = Math.random() * totalWeight; i < objs.length - 1; ++i) {
            currentWeight -= weights[i];
            if (currentWeight <= 0.0) {
                break;
            }
        }
        return objs[i];
    }

    public static char randomChoice(char[] objs) {
        double[] weights = new double[objs.length];
        Arrays.fill(weights, 1 / objs.length);
        return randomChoice(objs, weights);
    }
}
