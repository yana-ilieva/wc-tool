package org.example.counters;

import java.io.File;
import java.io.IOException;

public interface Counter {

    long[] count(File file) throws IOException;


}
