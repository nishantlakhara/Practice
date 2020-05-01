package hackerrank.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MinTimeMachine {
    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        //return bruteResult(machines, goal);
        return binaryResult(machines, goal);
    }

    private static long binaryResult(long[] machines, long goal) {
        long low = 0l;
        long high = 1000000000000000000l;
        long mid = 0l;
        long timeDone = 0l;
        long ans = 0l;

        while(low < high) {
            mid = low+high/2;
            timeDone = 0l;

            System.out.println(mid);
            for (int i=0; i<machines.length; i++) {
                timeDone += mid/machines[i];

                if(timeDone >= goal) {
                    break;
                }
            }

            if(timeDone >= goal) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static long bruteResult(long[] machines, long goal) {
        long totalItems = 0;
        int time=0;
        while(true) {

            totalItems = 0;
            for(int i=0; i<machines.length; i++) {
                totalItems = totalItems + time/machines[i];
            }

            if(totalItems >= goal) {
                return time;
            }
            time++;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);
        System.out.println(ans);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
