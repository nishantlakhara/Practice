package hackerrank.arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Result1 {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    /**
     * 1 1 1 0 0 0
     * 0 1 0 0 0 0
     * 1 1 1 0 0 0
     * 0 0 2 4 4 0
     * 0 0 0 2 0 0
     * 0 0 1 2 4 0
     * @param arr
     * @return
     */
    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        int sum = 0;
        for(int i=0; i<=3; i++) {
            for(int j=0; j<=3; j++) {
                int sumHourGlass = 0;
                //System.out.println(i + "," + j);
                sumHourGlass += arr.get(i).get(j);
                sumHourGlass += arr.get(i).get(j+1);
                sumHourGlass += arr.get(i).get(j+2);
                sumHourGlass += arr.get(i+1).get(j+1);
                sumHourGlass += arr.get(i+2).get(j);
                sumHourGlass += arr.get(i+2).get(j+1);
                sumHourGlass += arr.get(i+2).get(j+2);
                //System.out.println(sumHourGlass);
                if(i == 0 && j == 0) sum = sumHourGlass;
                else if(sumHourGlass > sum) { sum = sumHourGlass; }
            }
        }
        return sum;
    }

}

public class HourGlass {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = Result1.hourglassSum(arr);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

