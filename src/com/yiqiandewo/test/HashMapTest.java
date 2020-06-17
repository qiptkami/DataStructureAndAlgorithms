package com.yiqiandewo.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("a", 1);
        map.put("b", 1);
        map.put("a", 2);

        Set<String> s = map.keySet();

        for (String b : s) {
            System.out.println(b + ":" + map.get(b));
        }
    }
}
