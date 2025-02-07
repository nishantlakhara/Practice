import java.util.HashMap;
import java.util.Map;

public class LuxoftTest {
    public static void main(final String[] args) {
        //Welcome to this interview!
        //Please write program which will give possibility to find number of unique pairs in array of random integers.
        //Unique pair is two opposite leetcode.numbers, like [-2,2], [-6,6] etc. In other words - two leetcode.numbers with the same
        //absolute value but different sign.

        //Example input:
        int[] input = new int[]{7, -5, 6, 5, -8, 5, -5, 1, 7, 4, -1, -2, 1}; //We have two unique pairs in this array: [-5,5] and [-1,1]

        PairCounter pairCounter = new UniquePairCounter(input);

        //Expected result:
        //2
        System.out.println(pairCounter.countPairs());
    }
}

interface PairCounter {
    int countPairs();
}

class UniquePairCounter implements PairCounter {
    int[] input;

    public UniquePairCounter(int[] input) {
        this.input = input;
    }

    @Override
    public int countPairs() {
        Map<Integer, Boolean> map = new HashMap<>();

        //-5,7,-7,5,5
        //Map creation: -7, false  7,false  5,false -5,false
        for(int data: input) {
            map.put(data, false);
        }

        //-5,7,-7,5,5
        //Map creation: -7,true  7,true  5,true -5,true
        int count = 0;
        for(int data: input) {
            if(!map.get(data)) {
                //Check if map contains opposite sign.
                if(map.containsKey(-data)) {
                    count++;
                }
                map.put(data, true);
                map.put(-data, true);
            }
        }

        return count;
    }
}
