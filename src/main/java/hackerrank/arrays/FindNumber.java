package hackerrank.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FindNumber {


    // Complete the findNumber function below.
    static String findNumber(List<Integer> arr, int k) {
        int i=0;

        Collections.sort(arr);
        int mid = 0;
        int low = 0;
        int high = arr.size() - 1;
        int n = arr.size() - 1;
        while(low <= high) {
            mid = (i+k)/2;

            if(arr.get(mid) == k) {
                return "YES";
            }

            if(arr.get(mid) > k) {
                high = mid + 1;
            } else {
                low = mid -1;
            }

        }

        return "NO";

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.setProperty("OUTPUT_PATH", "/Users/nishantlakhara/Documents/Practice/src/out/output.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> arrTemp = new ArrayList<>();

        IntStream.range(0, arrCount).forEach(i -> {
            try {
                arrTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> arr = arrTemp.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String res = findNumber(arr, k);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

