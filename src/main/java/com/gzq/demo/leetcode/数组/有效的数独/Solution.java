package com.gzq.demo.leetcode.数组.有效的数独;

import java.util.HashMap;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int y = board.length;
        int x = board[0].length;
        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> xymap1 = new HashMap<>();
        HashMap<Integer, Integer> xymap2 = new HashMap<>();
        HashMap<Integer, Integer> xymap3 = new HashMap<>();
        HashMap<Integer, Integer> xymap4 = new HashMap<>();
        HashMap<Integer, Integer> xymap5 = new HashMap<>();
        HashMap<Integer, Integer> xymap6 = new HashMap<>();
        HashMap<Integer, Integer> xymap7 = new HashMap<>();
        HashMap<Integer, Integer> xymap8 = new HashMap<>();
        HashMap<Integer, Integer> xymap9 = new HashMap<>();
        // 遍历二维数组，并打印每个元素
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " "); // 打印当前元素
                if (i < 3) {
                    if (j < 3) {
                        if (board[i][j] != '.') {
                            if (xymap1.containsKey(board[i][j] - '0')) {
                                return false;
                            } else {
                                xymap1.put(board[i][j] - '0', 1);
                            }
                        }
                    } else if (j >= 3 && j < 6) {
                        if (board[i][j] != '.') {
                            if (xymap2.containsKey(board[i][j] - '0')) {
                                return false;
                            } else {
                                xymap2.put(board[i][j] - '0', 1);
                            }
                        }
                    } else {
                        if (board[i][j] != '.') {
                            if (xymap3.containsKey(board[i][j] - '0')) {
                                return false;
                            } else {
                                xymap3.put(board[i][j] - '0', 1);
                            }
                        }
                    }
                } else if (i >= 3 && i < 6) {
                    if (j < 3) {
                        if (board[i][j] != '.') {
                            if (xymap4.containsKey(board[i][j] - '0')) {
                                return false;
                            } else {
                                xymap4.put(board[i][j] - '0', 1);
                            }
                        }
                    } else if (j >= 3 && j < 6) {
                        if (board[i][j] != '.') {
                            if (xymap5.containsKey(board[i][j] - '0')) {
                                return false;
                            } else {
                                xymap5.put(board[i][j] - '0', 1);
                            }
                        }
                    } else {
                        if (board[i][j] != '.') {
                            if (xymap6.containsKey(board[i][j] - '0')) {
                                return false;
                            } else {
                                xymap6.put(board[i][j] - '0', 1);
                            }
                        }
                    }
                } else if (i >= 6) {
                    if (j < 3) {

                        if (board[i][j] != '.') {
                            if (xymap7.containsKey(board[i][j] - '0')) {
                                return false;
                            } else {
                                xymap7.put(board[i][j] - '0', 1);
                            }
                        }
                    } else if (j >= 3 && j < 6) {

                        if (board[i][j] != '.') {
                            if (xymap8.containsKey(board[i][j] - '0')) {
                                return false;
                            } else {
                                xymap8.put(board[i][j] - '0', 1);
                            }
                        }
                    } else {
                        if (board[i][j] != '.') {
                            if (xymap9.containsKey(board[i][j] - '0')) {
                                return false;
                            } else {
                                xymap9.put(board[i][j] - '0', 1);
                            }
                        }
                    }
                }
            }
            System.out.println(); // 打印换行符，进入下一行
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (xMap.containsKey(board[i][j] - '0')) {
                        return false;
                    } else {
                        xMap.put(board[i][j] - '0', 1);
                    }
                }
            }
            xMap.clear();
        }

        for (int j = 0; j < x; j++) {
            // 创建一个 HashMap 用于存储当前列 j 上的值
            HashMap<Character, Integer> columnMap = new HashMap<>();
            // 遍历当前列 j 上的每一行
            for (int i = 0; i < board.length; i++) {
                // 将 board[i][j] 的值存储到内层的 HashMap 中
                if (board[i][j] != '.') {
                    if (columnMap.containsKey(board[i][j])) {
                        return false;
                    } else {
                        columnMap.put(board[i][j], 1);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValidSudoku(new char[][]{
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        }));
    }
}

