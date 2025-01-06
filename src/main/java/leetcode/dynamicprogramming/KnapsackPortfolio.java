package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class KnapsackPortfolio {

    private static Integer max = 0;
    public static void main(String[] args) {
        test3();
    }

    private static int knapSack(int w,
                                KnapSackProblemBruteForce.Data[] data,
                                int n, List<KnapSackProblemBruteForce.Data> list,
                                List<List<KnapSackProblemBruteForce.Data>> maxData
                                ) {
        //Base cases
        if(n == 0 || w == 0) {
            //System.out.println(list);
            int max1 = list.stream().map(d -> d.getValue()).mapToInt(Integer::intValue).sum();

            if(max1 == max) {
                maxData.add(list);
            } else if(max1 > max) {
                maxData.clear();
                maxData.add(list);
                max = max1;
            }
            return 0;
        }

        List<KnapSackProblemBruteForce.Data> list1 = new ArrayList<>(list);

        //Exclude and move to next element if the weight of current element is greater than w
        if(data[n-1].getWeight() > w) {
            return knapSack(w, data, n-1, list1, maxData);
        }

        //Include the knapsack
        List<KnapSackProblemBruteForce.Data> list2 = new ArrayList<>(list);
        list2.add(data[n-1]);
        int include = data[n-1].getValue() + knapSack(w-data[n-1].getWeight(), data, n-1, list2, maxData);

        //Exclude the knapsack
        List<KnapSackProblemBruteForce.Data> list3 = new ArrayList<>(list);
        int exclude = knapSack(w, data, n-1, list3, maxData);

        return Math.max(include, exclude);
    }

    private static void test3() {
        List<KnapSackProblemBruteForce.Data> dataList = new ArrayList<>();
        dataList.add(new KnapSackProblemBruteForce.Data("Reliance", 4, 2000));
        dataList.add(new KnapSackProblemBruteForce.Data("HDFC Bank", 5, 1500));
        dataList.add(new KnapSackProblemBruteForce.Data("HDFC", 6, 2800));
        dataList.add(new KnapSackProblemBruteForce.Data("TCS", 7, 3800));
        dataList.add(new KnapSackProblemBruteForce.Data("Infosys", 3, 1600));
        dataList.add(new KnapSackProblemBruteForce.Data("Wipro", 1, 700));
        dataList.add(new KnapSackProblemBruteForce.Data("SBI Life Insurance", 2, 1200));

        List<List<KnapSackProblemBruteForce.Data>> maxData = new ArrayList<>();
        System.out.println(knapSack(11000,
                dataList.stream().toArray(KnapSackProblemBruteForce.Data[]::new),
                dataList.size(),
                new ArrayList<KnapSackProblemBruteForce.Data>(),
                maxData)
        );
        System.out.println("All combinations");
        final AtomicInteger count = new AtomicInteger();
        System.out.println(max);
        maxData.forEach(
                l -> {
                    System.out.println("==========List " + count.incrementAndGet());
                    System.out.println("List size == " + l.size());
                    l.stream().forEach(System.out::println);
                }
        );
    }

}

