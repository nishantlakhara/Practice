package leetcode;

public class SearchRange {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,3,3,3,4,5,9};
        int[] range = new SearchRange().searchRange(nums, 3);
        System.out.println("left = " + range[0] + "\t right = " + range[1]);
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length==0) {
            return new int[] {-1,-1};
        } else if(nums.length == 1) {
            return nums[0] == target ? new int[] {0,0} : new int[] {-1,-1};
        }

        //First check if element is present or not.
        //Check for left and right side of element.
        //If present,
        //Check left side and find out leftmost
        //Check right side and find out the rightmost.

        int low=0;
        int high = nums.length - 1;
        int mid = 0;

        while(low <= high) {
            mid = low + (high-low)/2;

            if(nums[mid] == target) {
                return checkRange(nums, low, high, mid, target);
            }

            //Check which side target is in.
            if(target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] {-1,-1};
    }

    public int[] checkRange(int[] nums, int low, int high, int mid, int target) {
        int leftIndex = low;
        int rightIndex = high;
        int left = 0;
        int right = 0;
        if(mid - 1 >= 0 && nums[mid-1] == target) {
            //Check in left side.
            left = checkLeft(nums, low, mid-1, target);
        } else {
            left = mid;
        }

        if(mid + 1 <= nums.length-1 && nums[mid+1] == target) {
            //Check in right side.
            right = checkRight(nums, mid+1, high, target);
        } else {
            right = mid;
        }

        return new int[] {left, right};
    }

    //2,3,4,8,8,8,8,8
    //8,8,8,8,8,8,8,8
    //2,3,4,4,4,4,5,6,7,7,7,8,8,8,8,8,8,8,8,8
    public int checkLeft(int[] nums, int low, int high, int target) {
        int mid = 0;
        while(low <= high) {
            mid = low + (high - low)/2;
            if(nums[mid] == target) {
                //Check left.
                if(mid - 1 >= 0 && nums[mid-1] != target) {
                    return mid;
                } else if(mid - 1 < 0) {
                    return mid;
                } else {
                    return checkLeft(nums, low, mid -1, target);
                }
            } else if(nums[mid] < target) {
                low = mid+1;
            }
        }
        return -1;
    }

    //8,8,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,10,10
    //8,8,8,8,8,8,8
    public int checkRight(int[] nums, int low, int high, int target) {
        int mid = 0;
        while(low <= high) {
            mid = low + (high - low)/2;
            if(nums[mid] == target) {
                //Check right.
                if(mid + 1 <= nums.length-1 && nums[mid+1] != target) {
                    return mid;
                } else if(mid + 1 > nums.length-1) {
                    return mid;
                } else {
                    return checkRight(nums, mid+1, high, target);
                }
            } else if(nums[mid] > target) {
                high = mid-1;
            }
        }
        return -1;
    }
}
