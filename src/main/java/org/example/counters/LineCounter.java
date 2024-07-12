package org.example.counters;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LineCounter implements Counter {
    @Override
    public long[] count(File file) throws IOException {
        try (Scanner scanner = new Scanner(file)) {
            long lines = 0;

            while (scanner.hasNextLine()) {
                lines++;
                scanner.nextLine();
            }

            return new long[] {lines};
        }
    }
}
