package numbers;

public class CountDivisors {
    
    public static void main(String[] args) {
        System.out.println(new CountDivisors().solution(6,11,2));
    }

    public int solution(int A, int B, int K) {
        // Implement your solution here
        if (K == 1) {
            return B - A;
        }

        int res = 0;
        int diff = B - A + 1;

        // 23,28    K=7, diff=5     end divisible + 0
        // 23,34    K=7, diff=10    end not divisible + 1
        // 21,35    K=7, diff=14    end divisible + 2
        // 21,34.   K=7, diff=13    end not divisible + 1 + start_div

        res += diff / K;
        if (B % K == 0) {
            res += 1;
        }
        // if(A % K == 0) {
        //     res += 1;
        // }

        return res;
    }
}
