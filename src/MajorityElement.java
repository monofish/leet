import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * @author Wei
 * @since 2/15/16
 */
public class MajorityElement {

    /**
     * <strong>Boyer–Moore majority vote algorithm</strong>
     *
     * @param nums a list of integers
     * @return find a majority number
     */
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 0;
        for (int n : nums) {
            if (count == 0) {
                major = n;
                count++;
            } else if (major == n) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

//    use Arrays.sort (quick sort) with O(n logn) to find the median
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len / 2];
    }

//    ArrayList implementaion for LintCode
//    public int majorityNumber(ArrayList<Integer> nums) {
//        int major = nums.get(0);
//        int count = 0;
//        for (int n : nums) {
//            if (count == 0) {
//                major = n;
//                count++;
//            } else if (major == n) { count++; }
//            else { count--; }
//        }
//        return major;
//    }

    public static void main(String[] args) {
        MajorityElement test = new MajorityElement();

        int[] nums1 = {1, 2, 3, 4, 5, 5, 5, 5, 7};
        System.out.println(test.majorityElement(nums1));
    }
}
