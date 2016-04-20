package com.hanleybrand.xnamer;

import java.io.IOException;

public class Main {

    public static void main() throws IOException{
        SimplePlaceNamer sp = new SimplePlaceNamer();
        String this_name = sp.get_name();

        System.out.println(this_name);

        //return this_name;

    }

}
