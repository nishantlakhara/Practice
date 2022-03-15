package leetcode.dynamicprogramming;

public class TrapRunningWater {
    public static void main(String[] args) {
        int[] heights = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(new TrapRunningWater().trap(heights));
    }

    public int trap(int[] height) {
        //Base case
        if(height.length == 0) {
            return 0;
        }

        //Initialize left and right
        int[] leftMaxSoFar = new int[height.length];
        int[] rightMaxSoFar = new int[height.length];

        //Initialize leftMaxSoFar array.
        leftMaxSoFar[0] = height[0];
        for(int i=1; i<height.length; i++) {
            leftMaxSoFar[i] = Math.max(leftMaxSoFar[i-1], height[i]);
        }

        //Intialize rightMaxSoFar array.
        rightMaxSoFar[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--) {
            rightMaxSoFar[i] = Math.max(rightMaxSoFar[i+1], height[i]);
        }

        //calculate trapped water.
        int sum = 0;
        for(int i=0; i<height.length; i++) {
            sum += Math.min(leftMaxSoFar[i], rightMaxSoFar[i]) - height[i];
        }

        return sum;
    }
}
