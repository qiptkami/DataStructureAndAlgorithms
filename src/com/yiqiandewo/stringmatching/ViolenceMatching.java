package com.yiqiandewo.stringmatching;

public class ViolenceMatching {
    public static void main(String[] args) {
        String s = "BBC ABCDAB ABCDABCDABDE";
        String p = "ABCDABD";

        System.out.println(violenceMatching(s, p));
    }

    public static boolean violenceMatching(String s, String p) {
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i+j) == p.charAt(j)) {
                j++;
            } else {
                i++;
                j = 0;
            }
        }

        return j == p.length();
    }
}
