package leetcode.greedy;

import java.util.Arrays;

public class MinimumArrowsBurstBalloons {
    public static void main(String[] args) {
        int[][] points = new int[][] {
                {4,6},
                {1,3},
                {2,4},
                {4,8},
                {3,7},
                {3,5}
        };
        Arrays.stream(points).
                forEach(point -> System.out.println(point[0] + "," +  point[1]));
    }
}
