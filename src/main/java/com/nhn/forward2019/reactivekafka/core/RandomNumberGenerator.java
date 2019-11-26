package com.nhn.forward2019.reactivekafka.core;

import java.util.Random;

public interface RandomNumberGenerator {
    default int getRandomRange(int start, int end) {
        return new Random()
                .ints(start, end)
                .findFirst()
                .orElse(start);
    }
}
