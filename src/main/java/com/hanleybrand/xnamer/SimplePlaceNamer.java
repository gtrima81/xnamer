package com.hanleybrand.xnamer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Random;


public class SimplePlaceNamer extends Namer {

    public JsonArray prefixes;
    public JsonArray suffixes;
    public int prefix_count;
    public int suffix_count;

    public SimplePlaceNamer() throws IOException {

        try (Reader reader = new InputStreamReader(

                SimplePlaceNamer
                        .class.getResourceAsStream("/data/place/ald-normanish.json"), StandardCharsets.UTF_8)) {

            Gson gson = new Gson();
            SimplePlace sp = gson.fromJson(reader, SimplePlace.class);

            prefixes = sp.PREFIX_A;
            suffixes = sp.SUFFIX_A;
            prefix_count = sp.PREFIX_A.size();
            suffix_count = sp.SUFFIX_A.size();
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Randomly generate a simple name from a list of prefixes and a list of suffixes, e.g prefix + suffix
     * test in REPL with
     * import com.hanleybrand.xnamer.SimplePlaceNamer;
     * SimplePlaceNamer sp = new SimplePlaceNamer();
     * sp.get_name();
     */

    public String get_name() {
        Random randomGenerator = new Random();

        int prefix_idx = randomGenerator.nextInt(prefix_count);
        int suffix_idx = randomGenerator.nextInt(suffix_count);

        return prefixes.get(prefix_idx).getAsString().concat(suffixes.get(suffix_idx).getAsString());
    }


    public static void main(String[] args) throws IOException {
        SimplePlaceNamer sp = new SimplePlaceNamer();
        System.out.println(sp.get_name());
    }
}
