package leetcode.slidingwindow.google;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 *
 *
 * Solution:
 *
 *
 * Overview
 * We have to maximize the Area that can be formed between the vertical lines using the shorter line as length and the distance between the lines as the width of the rectangle forming the area.
 *
 *
 * Approach 1: Brute Force
 * Algorithm
 *
 * In this case, we will simply consider the area for every possible pair of lines and find out the maximum area out of those.
 *
 * Note: Brute force approaches are often included because they are intuitive starting points when solving a problem. However, they are often expected to receive Time Limit Exceeded since they would not be accepted in an interview setting.
 *
 *
 * Complexity Analysis
 *
 * Time complexity: O(n
 * 2
 *  ). Calculating area for all
 * 2
 * n(n−1)
 * ​
 *   height pairs.
 * Space complexity: O(1). Constant extra space is used.
 * Approach 2: Two Pointer Approach
 * Algorithm
 *
 * The intuition behind this approach is that the area formed between the lines will always be limited by the height of the shorter line. Further, the farther the lines, the more will be the area obtained.
 *
 * We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines. Further, we maintain a variable maxarea to store the maximum area obtained till now. At every step, we find out the area formed between them, update maxarea, and move the pointer pointing to the shorter line towards the other end by one step.
 *
 * The algorithm can be better understood by looking at the example below:
 *
 * 1 8 6 2 5 4 8 3 7
 * Current
 *
 * How does this approach work?
 *
 * Initially, we consider the area constituting the exterior most lines. Now, to maximize the area, we need to consider the area between the lines of larger lengths. If we try to move the pointer at the longer line inwards, we won't gain any increase in area, since it is limited by the shorter line. But moving the shorter line's pointer could turn out to be beneficial, as per the same argument, despite the reduction in the width. This is done since a relatively longer line obtained by moving the shorter line's pointer might overcome the reduction in area caused by the width reduction.
 *
 * For further clarification click here and for the proof click here.
 *
 *
 * Complexity Analysis
 *
 * Time complexity: O(n). Single pass.
 *
 * Space complexity: O(1). Constant space is used.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int area = 0;

        while(l < r) {
            area = Math.max(area, (r-l)*Math.min(height[l], height[r]));

            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return area;
    }
}
