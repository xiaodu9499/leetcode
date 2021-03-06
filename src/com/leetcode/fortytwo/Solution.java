package com.leetcode.fortytwo;

/**
 * DESCRIPTION : 接雨水
 *
 * @author ducf
 * @create 2020-04-04 9:00 上午
 */
public class Solution {

    /*
    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

    上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

    示例:

    输入: [0,1,0,2,1,0,1,3,2,1,2,1]
    输出: 6

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/trapping-rain-water
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] example = new int[]{0, 3, 0, 2, 1, 6, 1, 3, 2, 1, 2, 7, 2};
        System.out.println(trap(example));
    }

    /**
     * 动态规划
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int sum = 0;
        // 找出位置索引上当前位置的左边最大数
        int[] maxLeft = new int[height.length];
        // 找出位置索引上当前位置的右边最大数
        int[] rightLeft = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightLeft[i] = Math.max(rightLeft[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i], rightLeft[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }


    /**
     *
     * 双指针
     * @param height
     * @return
     */
    public static int trap1(int[] height) {

        return 0;
    }


}
