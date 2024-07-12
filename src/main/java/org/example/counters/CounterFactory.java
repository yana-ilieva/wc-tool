package org.example.counters;

public class CounterFactory {
    public static Counter getCounter(Options option) {
        return switch (option) {
            case BYTES -> new ByteCounter();
            case LINES -> new LineCounter();
            case WORDS -> new WordCounter();
            case ALL -> new CombinedCounter();
        };
    }
}
