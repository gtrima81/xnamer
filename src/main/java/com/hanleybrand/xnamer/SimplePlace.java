package com.hanleybrand.xnamer;

import com.google.gson.JsonArray;


public class SimplePlace {
    public JsonArray PREFIX_A;
    public JsonArray SUFFIX_A;

    @Override
    public String toString() {

        String prefix_a = PREFIX_A.get(0).toString();
        String suffix_a = SUFFIX_A.get(0).toString();
        return "SimplePlace = PREFIX_A + SUFFIX_A; ex: " +  prefix_a  + suffix_a;
    }


}
