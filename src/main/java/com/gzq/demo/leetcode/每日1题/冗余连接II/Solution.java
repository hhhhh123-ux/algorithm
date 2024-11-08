package com.gzq.demo.leetcode.每日1题.冗余连接II;

public class Solution {

    public static void main(String[] args) {
        System.out.println(findRedundantDirectedConnection(new int[][]{}));
    }

    public static int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            
        }

        return new int[]{};
    }

    private int fund(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = fund(parent, parent[x]);
        }

        return parent[x];
    }

    private void union(int[] parent, int x, int y) {
        int xx = fund(parent, x);
        int yy = fund(parent, y);
        if (xx != yy) {
            parent[xx] = yy;
        }
    }
}
