package leetcode.greedy;

public class Candy {
    //O(n) S(n) solution.
    public int candy(int[] ratings) {
        int[] leftToRight = new int[ratings.length];
        int[] rightToLeft = new int[ratings.length];

        leftToRight[0] = 1;
        for(int i=1; i<ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                leftToRight[i] = leftToRight[i-1] + 1;
            } else {
                leftToRight[i] = 1;
            }
        }

        rightToLeft[ratings.length-1] = 1;
        for(int i=ratings.length-2; i>=0; i--) {
            if(ratings[i] > ratings[i+1]) {
                rightToLeft[i] = rightToLeft[i+1] + 1;
            } else {
                rightToLeft[i] = 1;
            }
        }

        int sum = 0;
        for(int i=0; i<ratings.length; i++) {
            sum += Math.max(leftToRight[i], rightToLeft[i]);
        }
        return sum;
    }
}
