package org.example.counters;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ByteCounter implements Counter {
    @Override
    public long[] count(File file) throws IOException {
        return new long[]{getBytes(file)};
    }

    protected long getBytes(File file) throws IOException {
        return Files.size(file.toPath());
    }
}
