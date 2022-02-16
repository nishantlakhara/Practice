package conversion;

import java.util.Arrays;
import java.util.List;

public class ConversionUtilities {
    public static void main(String[] args) {
        wrapperListToArrayPrimitive();


    }

    private static void wrapperListToArrayPrimitive() {
        //Convert list of wrapper class to array of primitive.
        List<Integer> ints = Arrays.asList(1,2,3,4);
        int[] intArray = ints.stream().mapToInt(Integer::intValue).toArray();
    }
}
