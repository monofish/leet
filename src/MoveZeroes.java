import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * @author Wei
 * @since 2/15/16
 */
public class MoveZeroes {

    // using swap
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) return;
        int i = 0;
        int temp;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }
    }

    // an alternative using RemoveElement with 2 loop parts
    public void moveZeroes1(int[] nums) {
        if (nums.length <= 1) return;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) { nums[i++] = nums[j]; }
        }
        for (; i < nums.length; i++) { nums[i] = 0; }   // set all remaining positions with zeroes
    }

    public static void main(String[] args) {
        MoveZeroes test = new MoveZeroes();

//        int[] nums1 = {0, 1, 2, 3, 12};
        int[] nums1 = {1, 0, 1, 2, 3, 12};
//        int[] nums1 = {2, 1};
        test.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
