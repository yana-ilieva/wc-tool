package org.example;

import org.example.counters.*;

import java.io.File;
import java.io.IOException;

public class WcToolApplication {

    private static String fileName;

    private static Options option;

    public static void main(String[] args) {
        int numberOfArgs = args.length;

        if (numberOfArgs == 1) {
            option = Options.get("nop");
            fileName = args[0];
        }
        if (numberOfArgs == 2) {
            try {
                option = Options.get(args[0]);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid option\n" + e.getMessage());
                System.exit(1);
            }
            fileName = args[1];
        }

        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File does not exist");
            System.exit(1);
        }

        Counter counter = CounterFactory.getCounter(option);

        try {
            long[] counts = counter.count(file);
            System.out.println(constructOutput(counts));
            System.exit(0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private static String constructOutput(long[] counts) {
        StringBuilder builder = new StringBuilder();
        for (long count : counts) {
            builder.append(count).append("\t");
        }
        builder.append(fileName);
        return builder.toString();
    }
}
