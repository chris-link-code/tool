package com.demo.util.diff;// Copyright 2010 Google Inc. All Rights Reserved.

/**
 * Diff Speed Test
 * <p>
 * Compile from diff-match-patch/java with:
 * javac -d classes src/name/fraser/neil/plaintext/diff_match_patch.java tests/name/fraser/neil/plaintext/Speedtest.java
 * Execute with:
 * java -classpath classes name/fraser/neil/plaintext/Speedtest
 *
 * @author fraser@google.com (Neil Fraser)
 */

import com.demo.util.diff.diff.DiffMatchPatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SpeedTest {

    public static void main(String args[]) throws IOException {
        String path = System.getProperty("user.dir");
        System.out.println("当前位置: " + path);

        String text1 = readFile("./src/test/java/com/demo/util/diff/Speedtest1.txt");
        String text2 = readFile("./src/test/java/com/demo/util/diff/Speedtest2.txt");

        DiffMatchPatch dmp = new DiffMatchPatch();
        dmp.Diff_Timeout = 0;

        // Execute one reverse diff as a warmup.
        dmp.diff_main(text2, text1, false);

        long start = System.currentTimeMillis();
        //long start_time = System.nanoTime();
        dmp.diff_main(text1, text2, false);
        long end = System.currentTimeMillis();
        //long end_time = System.nanoTime();
        //System.out.printf("Elapsed time: %f\n", ((end_time - start_time) / 1000000000.0));
        System.out.println("Elapsed time: " + (end - start));
    }

    private static String readFile(String filename) throws IOException {
        // Read a file from disk and return the text contents.
        StringBuilder sb = new StringBuilder();
        FileReader input = new FileReader(filename);
        BufferedReader bufRead = new BufferedReader(input);
        try {
            String line = bufRead.readLine();
            while (line != null) {
                sb.append(line).append('\n');
                line = bufRead.readLine();
            }
        } finally {
            bufRead.close();
            input.close();
        }
        return sb.toString();
    }
}
