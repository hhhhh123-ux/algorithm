package com.gzq.demo.leetcode.每日1题.统计上升四元组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countQuadruplets(new int[]{178, 152, 109, 281, 196, 227, 272, 66, 224, 233, 51, 248, 39, 118, 111, 230, 250, 255, 114, 125, 221, 299, 205, 186, 181, 5, 61, 115, 228, 169, 101, 287, 269, 80, 57, 107, 143, 75, 198, 54, 53, 172, 40, 29, 96, 256, 83, 258, 74, 236, 241, 138, 261, 192, 128, 244, 234, 298, 214, 184, 168, 7, 164, 103, 3, 46, 249, 204, 288, 175, 85, 116, 130, 151, 275, 273, 217, 166, 124, 296, 136, 48, 158, 153, 291, 277, 268, 211, 30, 167, 20, 243, 276, 95, 202, 49, 246, 87, 9, 231, 50, 6, 56, 266, 24, 72, 11, 286, 189, 180, 37, 156, 94, 35, 280, 52, 117, 257, 159, 297, 160, 68, 112, 283, 64, 104, 220, 18, 38, 133, 1, 179, 193, 222, 219, 67, 289, 194, 16, 145, 173, 79, 163, 47, 290, 176, 191, 92, 42, 239, 139, 119, 253, 26, 123, 141, 264, 134, 23, 285, 32, 174, 206, 215, 146, 203, 254, 140, 28, 13, 161, 148, 267, 63, 88, 70, 182, 260, 2, 232, 19, 90, 33, 149, 27, 25, 144, 73, 293, 131, 135, 108, 201, 122, 185, 237, 235, 165, 69, 147, 59, 21, 245, 89, 45, 209, 102, 284, 120, 106, 110, 36, 78, 274, 97, 197, 41, 105, 91, 251, 98, 177, 34, 60, 82, 240, 216, 208, 84, 225, 187, 282, 207, 76, 55, 199, 71, 127, 292, 271, 129, 212, 100, 226, 195, 247, 223, 263, 10, 188, 142, 62, 113, 183, 242, 43, 137, 81, 229, 170, 8, 17, 14, 171, 238, 150, 15, 44, 121, 213, 190, 270, 154, 4, 93, 157, 65, 279, 262, 259, 278, 200, 265, 252, 77, 132, 12, 58, 162, 210, 22, 126, 99, 294, 295, 218, 31, 86, 155}));
    }

    // 打印 List<Integer[]> 的方法
    public static void printList(List<Integer[]> list) {
        for (Integer[] array : list) {
            // 使用 Arrays.toString() 打印数组
            System.out.println(Arrays.toString(array));
        }
    }

    public long countQuadruplets(int[] nums) {
        int len = nums.length;
        long count = 0;
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    for (int l = k + 1; l < len; l++) {
                        // 每次创建一个新的数组实例
                        Integer[] integers = new Integer[4];
                        integers[0] = nums[i];
                        integers[1] = nums[j];
                        integers[2] = nums[k];
                        integers[3] = nums[l];
                        if (integers[0] < integers[2] && integers[1] < integers[3] && integers[2] < integers[1]) {
                            list.add(integers);
                        }

                    }
                }
            }
        }
        count = list.size();
        return count;
    }
}
