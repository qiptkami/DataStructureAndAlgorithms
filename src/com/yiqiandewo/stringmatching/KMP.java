package com.yiqiandewo.stringmatching;

public class KMP {
    public static void main(String[] args) {
        String s = "BBC ABCDAB ABCDABCDABDE";
        String p = "ABCDABDF";
        System.out.println(kmpSearch(s, p));
    }

    public static boolean kmpSearch(String s, String p) {
        int[] next = getNext(p);
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = next[j -1];
            }

            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == p.length();
    }

    private static int[] getNext(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < next.length; i++) {

            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            next[i] = j;
        }

        return next;
    }


}
