package leetcode;

import java.util.Arrays;

public class HashCodeGenerator {
    int[] nums;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashCodeGenerator that = (HashCodeGenerator) o;
        return Arrays.equals(nums, that.nums);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(nums);
    }
}
