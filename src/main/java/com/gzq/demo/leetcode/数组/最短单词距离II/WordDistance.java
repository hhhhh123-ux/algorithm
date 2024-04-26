package com.gzq.demo.leetcode.数组.最短单词距离II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordDistance {
    HashMap<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (map.containsKey(word)) {
                map.get(word).add(i);
            } else {
                map.put(word, new ArrayList<>());
                map.get(word).add(i);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> map1 = map.get(word1);
        List<Integer> map2 = map.get(word2);
        int size1 = map1.size(), size2 = map2.size();
        int pos1 = 0, pos2 = 0;
        int ans = Integer.MAX_VALUE;
        while (pos1 < size1 && pos2 < size2) {
            int index1 = map1.get(pos1), index2 = map2.get(pos2);
            ans = Math.min(ans, Math.abs(index1 - index2));
            if (index1 < index2) {
                pos1++;
            } else {
                pos2++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        WordDistance wordDistance = new WordDistance(wordsDict);
        System.out.println(wordDistance.shortest("coding", "practice"));
        System.out.println(wordDistance.shortest("makes", "coding"));
    }
}
