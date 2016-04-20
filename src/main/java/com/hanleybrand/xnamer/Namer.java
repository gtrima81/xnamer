package com.hanleybrand.xnamer;

import java.util.ArrayList;
import java.util.List;

public class Namer {

    private String capitalize_name(String name) {
        return Character.toString(name.charAt(0)).toUpperCase() + name.substring(1);
    }

    public String choice_from_list(ArrayList<String> list){
        int idx = (int)(Math.random() * (list.size() + 1));
        return list.get(idx);
    }

}
