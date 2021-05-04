public class MaxTwoElements {

    public static void main(String[] args) {
        int[] arr = {5,3,4,1,2,6};

        int max;
        int secondMax;

        int first = arr[0];
        int second = arr[1];

        if(first>second) {
            max = first;
            secondMax = second;
        } else {
            max = second;
            secondMax = first;
        }

        int temp;
        for(int i=2; i<arr.length; i++) {
            System.out.println(arr[i]);
            if(max < arr[i]) {
                temp = max;
                max = arr[i];
                secondMax = temp;
            } else if(secondMax < arr[i]) {
                secondMax = arr[i];
            }
            System.out.println(max);
            System.out.println(secondMax);
        }

        System.out.println("Max == " + max);
        System.out.println("secondMax == " + secondMax);
    }
}
