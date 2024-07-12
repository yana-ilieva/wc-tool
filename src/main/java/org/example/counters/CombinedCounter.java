package org.example.counters;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class CombinedCounter implements Counter {
    @Override
    public long[] count(File file) throws IOException {
        long[] result = new long[3];
        result[0] = Files.size(file.toPath());

        long words = 0;
        long lines = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lines++;
                int wordsInLine = scanner.nextLine().split("\\s").length;
                words += wordsInLine;
            }
        }

        result[1] = lines;
        result[2] = words;

        return result;
    }
}
