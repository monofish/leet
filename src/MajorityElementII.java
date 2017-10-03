import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 * <p>
 * Hint:<br>
 * How many majority elements could it possibly have?
 *
 * @author Wei
 * @since 2/16/16
 */
public class MajorityElementII {
    /**
     * A Generalization of <em>Boyer–Moore majority vote algorithm</em>
     *
     * @param nums A list of integers
     * @return The majority number that occurs more than 1/3
     */
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int n : nums) {
            if (candidate1 == n) {  // (candidate1 == n) must appear before (count2 == 0),
                                    // otherwise c2 may "steal" c1's vote.
                count1++;
            } else if (candidate2 == n) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1++;
            } else if (count2 == 0) {
                candidate2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (candidate1 == n) { count1++; }
            else if (candidate2 == n) { count2++; }
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) { result.add(candidate1); }
        if (count2 > nums.length / 3) { result.add(candidate2); }
        return result;

    }

//    // for LintCode
//    public int majorityNumber(ArrayList<Integer> nums) {
//        int candidate1 = 0;
//        int candidate2 = 0;
//        int count1 = 0;
//        int count2 = 0;
//        for (int n : nums) {
//            if (count1 == 0) {
//                candidate1 = n;
//                count1++;
//            } else if (candidate1 == n) {
//                count1++;
//            } else if (count2 == 0) {   // (candidate1 == n) must appear before (count2 == 0),
//                                        // otherwise c2 may "steal" c1's vote.
//                candidate2 = n;
//                count2++;
//            } else if (candidate2 == n) {
//                count2++;
//            } else {
//                count1--;
//                count2--;
//            }
//        }
//
//        count1 = 0;
//        count2 = 0;
//        for (int n : nums) {
//            if (candidate1 == n) { count1++; }
//            else if (candidate2 == n) { count2++; }
//        }
//
//        if (count1 > nums.size() / 3 && count1 >= count2) { return candidate1; }
//        else if (count2 > nums.size() / 3) { return candidate2; }
//        else return 0;
//    }

    public static void main(String[] args) {
        MajorityElementII test = new MajorityElementII();

        int[] nums1 = {1,1,1,1,2,2,3,3,4,4,4};
        System.out.println(test.majorityElement(nums1));

//        ArrayList<Integer> nums2 = new ArrayList<>();
//        for(int n : nums1) { nums2.add(n); }
//        System.out.println(test.majorityNumber(nums2));
    }
}
