import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * For example,
 * Given input array nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 *
 * @author Wei
 * @since 11/31/15
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * @param nums a array of integers
     * @return an integer of length
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) { return nums.length; } // not necessary but saving a little time
        int i = 1;
        for (int n : nums) {
            if (nums[i - 1] < n) { nums[i++] = n; } // keep the 1st occurrence [i-1] and replace the 2nd occurrence [i]
        }
        return i;   // i always increments after replacing the duplicate
    }

    // See an alternative implementation with i starting from 0
    public int removeDuplicates1(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (nums[i] < n) nums[++i] = n; // keep the 1st occurrence [i] and replace the 2nd occurrence [++i]
        }
        return i + 1;   // The array length is always the last index plus 1
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray test = new RemoveDuplicatesFromSortedArray();

        int[] nums1 = {1,2,3,4,5,5,5,6,7};
        System.out.println(test.removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));
    }
}
