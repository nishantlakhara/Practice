package leetcode.arrays;

public class Rotate {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        new Rotate().rotate(matrix);

        int[][] matrix2 = new int[][] {
                {1,2},
                {3,4}
        };
        new Rotate().rotate(matrix2);

        int[][] matrix3 = new int[][] {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        new Rotate().rotate(matrix3);
    }
    //Clockwise.
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int i = 0;
        int j = 0;
        int ie = n-1;
        int je = n-1;

//        print(matrix);

        while(n > 1 && i<ie && j<je) {
            int[] temp = createTemp(matrix, i, j, ie, je);
//            for(int k: temp) {
//                System.out.print(k);
//            }
//            System.out.println();

            updateNumsLeftToTop(matrix, i, j, ie, je);
//            print(matrix);

            updateNumsBottomToLeft(matrix, i, j, ie, je);
//            print(matrix);

            updateNumsRightToBottom(matrix, i, j, ie, je);
//            print(matrix);

            updateNumsTempToRight(matrix, temp, i, j, ie, je);
//            print(matrix);


            print(matrix);

            i += 1;
            j += 1;
            ie -= 1;
            je -= 1;
            n -= 1;
        }
    }

    private void print(int[][] matrix) {
        for(int k = 0; k< matrix.length; k++) {
            for(int l = 0; l< matrix.length; l++) {
                System.out.print(matrix[k][l]);
            }
            System.out.println();
        }
        System.out.println("--------------");
    }

    // 0,0 0,1 0,2 0,3
    // 1,0 1,1 1,2 1,3
    // 2,0 2,1 2,2 2,3
    // 3,0 3,1 3,2 3,3
    public void updateNumsTempToRight(int[][] nums, int[] temp, int i, int j, int ie, int je) {
        int k = 0;
        while(i <= ie) {
            nums[i][je] = temp[k];
            i++;
            k++;
        }
    }


    public void updateNumsRightToBottom(int[][] nums, int i, int j, int ie, int je) {
        int k = ie;
        while(j <= je) {
            nums[ie][j] = nums[k][je];
            j++;
            k--;
        }
    }


    public void updateNumsBottomToLeft(int[][] nums, int i, int j, int ie, int je) {
        int k = j;
        while(i <= ie) {
            nums[i][k] = nums[ie][j];
            i++;
            j++;
        }
    }

    public void updateNumsLeftToTop(int[][] nums, int i, int j, int ie, int je) {
        int k = i;
        while(k <= ie) {
            nums[i][je] = nums[k][j];
            je--;
            k++;
        }
    }

    public int[] createTemp(int[][] nums, int i, int j, int ie, int je) {
        int[] temp = new int[ie - i + 1];

        int k = 0;
        while(j <= je) {
            //System.out.println(i + "," + j);
            temp[k] = nums[i][j];
            j++;
            k++;
        }

        return temp;
    }
}
