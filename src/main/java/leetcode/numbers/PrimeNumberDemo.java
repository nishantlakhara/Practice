package leetcode.numbers;

import java.util.Arrays;

public class PrimeNumberDemo {
    public static void main(String[] args) {
//        Timing.timed(() -> primeNumbersTillN(1000000), System.out::println);
//        Timing.timed(() -> buildSievePrimeNumbers(1000000), System.out::println);

        boolean[] primes1 = primeNumbersTillN(1000000);
        boolean[] primes2 = buildSievePrimeNumbers(1000000);

//        Verify the result of both algo is correct.
//        for(int i=0; i<primes1.length; i++) {
//            if(primes1[i] != primes2[i]) {
//                System.out.println("There is problem in one of the algorithms. Check number " + i);
//                break;
//            }
//        }
    }

    private static boolean[] primeNumbersTillN(int n) {
        boolean[] primes = new boolean[n+1];
        for(int i=0; i<=n; i++) {
            //System.out.println("i=="+i + "\tisPrime==" + isPrime(i));
            primes[i] = isPrime(i);
        }
        return primes;
    }

    private static boolean isPrime(int n) {
        //Corner cases.
        if(n<=1)
            return false;
        if(n<=3)
            return true;

        //Eliminate multiples of 2.
        if(n%2==0)
            return false;

        for(int i=3; i<=Math.sqrt(n); i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
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
}
