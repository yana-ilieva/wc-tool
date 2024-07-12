package org.example.counters;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordCounter implements Counter {
    @Override
    public long[] count(File file) throws IOException {
        try (Scanner scanner = new Scanner(file)) {
            long words = 0;

            while (scanner.hasNextLine()) {
                int wordsInLine = scanner.nextLine().split("\\s").length;
                words += wordsInLine;
            }

            return new long[] {words};
        }
    }
}
