package org.study;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.infra.Blackhole;

import java.util.stream.IntStream;

// https://davidvlijmincx.com/posts/jmh-benchmark-java/

public class JMHExample {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void standardLoop(Blackhole blackhole) {
        long result = 0;
        for (int i = 0; i < 1000; i++) {
            result += 1;
        }
        blackhole.consume(result);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void streamLoop(Blackhole blackhole) {
        blackhole.consume(IntStream.range(0, 1000)
                .map(i -> 1)
                .sum());
    }

}
