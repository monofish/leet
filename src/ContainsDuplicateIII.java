import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array
 * such that the difference between <code>nums[i]</code> and <code>nums[j]</code> is at most t and the difference between i and j is at most k.
 *
 * @author Wei
 * @since 11/30/15
 *
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0 || k == 0) return false;

        Map<Integer, Integer> buckets = new HashMap<>();
        int size = nums.length;
        t++;    // avoid dividing by zero when t == 0
        for (int i = 0; i < size; i++) {
            if (i > k) buckets.remove(getIndex(nums[i - k - 1], t));    // keep the size of hash map in k
            int index = getIndex(nums[i], t);
            if (buckets.containsKey(index)) return true;
            if (buckets.containsKey(index - 1) && Math.abs(nums[i] - buckets.get(index - 1)) < t) return true;
            if (buckets.containsKey(index + 1) && Math.abs(nums[i] - buckets.get(index + 1)) < t) return true;
            buckets.put(index, nums[i]);
        }
        return false;
    }

    private int getIndex(int num, int t) {
        return num < 0 ? (num + 1) / t - 1 : num / t;   // deal with negative division issue in Java
    }

    public static void main(String[] args) {
        ContainsDuplicateIII test = new ContainsDuplicateIII();

        int[] nums1 = {0,10,22,15,0,5,22,12,1,5};
        System.out.println(test.containsNearbyAlmostDuplicate(nums1, 3, 3));    // false
        int[] nums2 = {1,2};
        System.out.println(test.containsNearbyAlmostDuplicate(nums2, 0, 1));    // false
        int[] nums3 = {1,3,1};
        System.out.println(test.containsNearbyAlmostDuplicate(nums3, 1, 1));    // false
        int[] nums4 = {1,0,1,1};
        System.out.println(test.containsNearbyAlmostDuplicate(nums4, 1, 0));    // true


        System.out.println(null == null);
    }
}
