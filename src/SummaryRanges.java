import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p>
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 * @author Wei
 * @since 2/15/16
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();

        if (nums.length < 1) {
            for (int i : nums) ranges.add(Integer.toString(i));
            return ranges;
        }

        int i = 0;
        int j = 0;
        for (; j < nums.length; j++) {
            if (j == nums.length - 1 || nums[j + 1] != nums[j] + 1) {   // avoid overflow of subtraction between 2 numbers
                if (i == j) { ranges.add(Integer.toString(nums[i])); }
                else { ranges.add(Integer.toString(nums[i]) + "->" + Integer.toString(nums[j])); }
                i = j + 1;
            }
        }
        return ranges;
    }

    public static void main(String[] args) {
        SummaryRanges test = new SummaryRanges();

//        int[] nums1 = {0, 1, 2, 3, 12};
        int[] nums1 = {-2147483648,-2147483647,2147483647};
        List<String> ranges = test.summaryRanges(nums1);
        for (String s : ranges) System.out.println(s);
    }
}
