package leetcode.dynamicprogramming;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class KnapSackProblemBruteForce {
    private static List<Data> finalDataList = new ArrayList<>();
    private static Map<Integer, List<List<Data>>> finalDataMap = new HashMap<>();

    public static void main(String args[])
    {
        //test1();
        //test2();
        test3();
    }

    private static void test2() {
        List<Data> dataList = new ArrayList<>();
        dataList.add(new Data("Table", 500, 1));
        dataList.add(new Data("Chair", 6500, 1));
        dataList.add(new Data("Bed", 30000, 1));
        dataList.add(new Data("Washing Machine", 10000, 1));
        dataList.add(new Data("Tread Mill", 15000, 1));
        dataList.add(new Data("Almirah", 6000, 1));
        dataList.add(new Data("Almirah Small", 5000, 1));
        dataList.add(new Data("Almirah medium",7000, 1));
        dataList.add(new Data("Almirah Mummy", 12000, 1));
        dataList.add(new Data("Dining Table", 3000, 1));
        dataList.add(new Data("TV", 15000, 1));
        dataList.add(new Data("Fridge", 3000, 1));
        dataList.add(new Data("Sofa", 40000, 1));
        dataList.add(new Data("Machaan", 3000, 1));
        dataList.add(new Data("Speakers and accesories", 15000, 1));

        System.out.println(knapSack(7,
                dataList.stream().toArray(Data[]::new),
                dataList.size(),
                new ArrayList<Data>()));
        finalDataList.forEach(System.out::println);
        System.out.println("All combinations");
        final AtomicInteger count = new AtomicInteger();
        finalDataMap.get(max).forEach(
                l -> {
                    System.out.println("==========List " + count.incrementAndGet());
                    System.out.println("List size == " + l.size());
                    l.stream().forEach(System.out::println);
                }
        );
    }

    private static void test3() {
        List<Data> dataList = new ArrayList<>();
        dataList.add(new Data("Reliance", 4, 2000));
        dataList.add(new Data("HDFC Bank", 5, 1500));
        dataList.add(new Data("HDFC", 6, 2800));
        dataList.add(new Data("TCS", 7, 3800));
        dataList.add(new Data("Infosys", 3, 1600));
        dataList.add(new Data("Wipro", 1, 700));
        dataList.add(new Data("SBI Life Insurance", 2, 1200));

        System.out.println(knapSack(11000,
                dataList.stream().toArray(Data[]::new),
                dataList.size(),
                new ArrayList<Data>()));
        finalDataList.forEach(System.out::println);
        System.out.println("All combinations");
        final AtomicInteger count = new AtomicInteger();
        finalDataMap.get(max).forEach(
                l -> {
                    System.out.println("==========List " + count.incrementAndGet());
                    System.out.println("List size == " + l.size());
                    l.stream().forEach(System.out::println);
                }
        );
    }

    private static void test1() {
        int val[] = new int[]{60, 100, 120, 170, 250, 50, 70};
        int wt[] = new int[]{10, 20, 30, 40, 50, 10, 15};
        int  W = 100;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
        System.out.println(knapSack(W, wt, val, n, new ArrayList<Integer>()));
        System.out.println(finalList);
        System.out.println(finalMap.get(max));
    }

    private static List<Integer> finalList = new ArrayList<>();
    private static Map<Integer, List<List<Integer>>> finalMap = new HashMap<>();

    private static int max = 0;

    private static int knapSack(int w, int[] wt, int[] val, int n) {
        //Base cases
        if(n == 0 || w == 0) {
            return 0;
        }

        //Exclude and move to next element if the weight of current element is greater than w
        if(wt[n-1] > w) {
            return knapSack(w, wt, val, n-1);
        }

        //Include the knapsack
        int include = val[n-1] + knapSack(w-wt[n-1], wt, val, n-1);

        //Exclude the knapsack
        int exclude = knapSack(w, wt, val, n-1);

        return Math.max(include, exclude);
    }

    private static int knapSack(int w, int[] wt, int[] val, int n, List<Integer> list) {
        //Base cases
        if(n == 0 || w == 0) {
            //System.out.println(list);
            int max1 = list.stream().mapToInt(Integer::intValue).sum();

            if(max1 >= max) {
                max = max1;
                finalList.clear();
                finalList.addAll(list);

                if(!finalMap.containsKey(max)) {
                    finalMap.put(max, new ArrayList<>());
                }
                finalMap.get(max).add(list);
            }
            return 0;
        }

        List<Integer> list1 = new ArrayList<>(list);

        //Exclude and move to next element if the weight of current element is greater than w
        if(wt[n-1] > w) {
            return knapSack(w, wt, val, n-1, list1);
        }

        //Include the knapsack
        List<Integer> list2 = new ArrayList<>(list);
        list2.add(val[n-1]);
        int include = val[n-1] + knapSack(w-wt[n-1], wt, val, n-1, list2);

        //Exclude the knapsack
        List<Integer> list3 = new ArrayList<>(list);
        int exclude = knapSack(w, wt, val, n-1, list3);

        return Math.max(include, exclude);
    }

    private static int knapSack(int w, Data[] data, int n, List<Data> list) {
        //Base cases
        if(n == 0 || w == 0) {
            //System.out.println(list);
            int max1 = list.stream().map(d -> d.getValue()).mapToInt(Integer::intValue).sum();

            if(max1 >= max) {
                max = max1;
                finalDataList.clear();
                finalDataList.addAll(list);

                if(!finalDataMap.containsKey(max)) {
                    finalDataMap.put(max, new ArrayList<>());
                }
                finalDataMap.get(max).add(list);
            }
            return 0;
        }

        List<Data> list1 = new ArrayList<>(list);

        //Exclude and move to next element if the weight of current element is greater than w
        if(data[n-1].getWeight() > w) {
            return knapSack(w, data, n-1, list1);
        }

        //Include the knapsack
        List<Data> list2 = new ArrayList<>(list);
        list2.add(data[n-1]);
        int include = data[n-1].getValue() + knapSack(w-data[n-1].getWeight(), data, n-1, list2);

        //Exclude the knapsack
        List<Data> list3 = new ArrayList<>(list);
        int exclude = knapSack(w, data, n-1, list3);

        return Math.max(include, exclude);
    }

    static class Data {
        String item;
        int value;
        int weight;

        public Data(String item, int value, int weight) {
            this.item = item;
            this.value = value;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Data data = (Data) o;
            return value == data.value &&
                    weight == data.weight &&
                    Objects.equals(item, data.item);
        }

        @Override
        public int hashCode() {

            return Objects.hash(item, value, weight);
        }

        public String getItem() {
            return item;
        }

        public int getValue() {
            return value;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "item='" + item + '\'' +
                    ", value=" + value +
                    ", weight=" + weight +
                    '}';
        }
    }
}
