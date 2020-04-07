package com.leetcode.interviewquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TransferQueue;

/**
 * DESCRIPTION :  旋转矩阵
 *
 * @author ducf
 * @create 2020-04-07 9:28 上午
 */
public class ZeroOneZeroSeven {

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];

        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = i * 3 + j + 1;
            }
        }


        print(matrix);
        rotate(matrix);
        System.out.println("-------------------");
        print(matrix);


    }

    private static void print(int[][] matrix ){
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            List<Object> objects = new ArrayList<>();
            for (int ints : matrix[i]) {
                objects.add(ints);
            }
            System.out.println(objects);
        }
    }

    /*
        给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。

        不占用额外内存空间能否做到？

        给定 matrix =
        [
          [1,2,3],
          [4,5,6],
          [7,8,9]
        ],

        原地旋转输入矩阵，使其变为:
        [
          [7,4,1],
          [8,5,2],
          [9,6,3]
        ]

        给定 matrix =
        [
          [ 5, 1, 9,11],
          [ 2, 4, 8,10],
          [13, 3, 6, 7],
          [15,14,12,16]
        ],

        原地旋转输入矩阵，使其变为:
        [
          [15,13, 2, 5],
          [14, 3, 4, 1],
          [12, 6, 8, 9],
          [16, 7,10,11]
        ]
     */
    public static void rotate(int[][] matrix) {
        // 以斜对角（左上-右下） 进行翻转
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        System.out.println("斜对角交换");
        print(matrix);

        // 再对每行进行翻转
        int mid = length / 2;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < mid; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length - 1 - j];
                matrix[i][length - 1 - j] = temp;
            }
        }
    }
}
