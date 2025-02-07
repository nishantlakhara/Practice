package leetcode.numbers;

import java.util.Arrays;

public class StringSplitPrimeNumbers {
    static int MAX_DIGITS = 6; //Indicating prime leetcode.numbers between 1 to 999999
    static boolean[] sieve;
    static int MOD = 1000000007;

    public static void main(String[] args) {
        //String s = "11373";
        sieve = buildSievePrimeNumbers(1000000);
        System.out.println(countSplitStringPrimes("11373", 0));
        System.out.println(countSplitStringPrimes("65464", 0));
        System.out.println(countSplitStringPrimes("2357111317192329313741435359", 0));
        System.out.println(countSplitStringPrimes("2357111317100092329313741435359", 0));
        System.out.println(countSplitStringPrimes("00235711131710009232931374143535900", 0));
//        System.out.println(countSplitStringPrimes("002357111317100092329313741435359", 0));
    }

    private static boolean[] buildSievePrimeNumbers(int n) {
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);

        primes[0] = false;
        primes[1] = false;

        for(int p=2; p*p<=n; p++) {
            if(primes[p] == true) {
                //Put all multiples of prime till n to false
                for(int j=p*p; j<=n; j+=p) {
                    primes[j] = false;
                }
            }
        }

        return primes;
    }

    private static int countSplitStringPrimes(String s, int index) {
        if(index == s.length()) {
            return 1;
        }

        int count = 0;

        for(int i=1; i<=MAX_DIGITS; i++) {
           if(index+i <= s.length()) {
               String num = s.substring(index, index+i);
               //System.out.println(num);
               if(isPrime(num)) {
                    //System.out.println(num);
                    count += countSplitStringPrimes(s, index+i);
                    count %= MOD;
               }
           }
        }

        return count;
    }

    private static boolean isPrime(String num) {
        return sieve[Integer.parseInt(num)];
    }
}
