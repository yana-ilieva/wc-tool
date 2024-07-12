package org.example.counters;

import java.util.HashMap;
import java.util.Map;

public enum Options {
    BYTES("-c"),
    LINES("-l"),
    WORDS("-w"),
    ALL("nop");

    private static final Map<String, Options> ENUM_MAP;

    public final String option;

    Options(String option) {
        this.option = option;
    }

    static {
        ENUM_MAP = new HashMap<>();
        for (Options o : Options.values()) {
            ENUM_MAP.put(o.option, o);
        }
    }

    public static Options get(String name) {
        return ENUM_MAP.get(name);
    }
}
