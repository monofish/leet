import java.util.ArrayList;
import java.util.List;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that
 * there may be more than one LIS combination, it is only necessary for you to return the length.
 * <p>
 * Your algorithm should run in O(n2) complexity.
 * <p>
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 * @author Wei
 * @since 3/2/16
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        List<List<Integer>> list = new ArrayList<>(nums.length);
        list.get(0).add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(j). )
            }
        }
    }
}
