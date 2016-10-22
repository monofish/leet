import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that <code>nums[i] = nums[j]</code> and the difference between i and j is at most k.
 *
 * @author Wei
 * @since 11/30/15
 */
public class ContainsDuplicateII {
    /**
     * @param k    the maximum difference between indices; that is to say the capacity of the no-duplicate subarray is k + 1.
     * @param nums a number represented as an array of digits
     * @return true if any duplicates
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>(k + 1);
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) {
//                System.out.println(Integer.toString(nums[i]));
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII test = new ContainsDuplicateII();

        int range1 = 100;
        int k1 = 1;
        int[] intArray1 = new int[range1];
        Random rand = new Random();
        for (int i = 0; i < range1; i++) {
            intArray1[i] = rand.nextInt(range1);
        }
        System.out.println(Arrays.toString(intArray1));
        System.out.println(test.containsNearbyDuplicate(intArray1, k1));


        int[] intArray2 = new int[]{-1, -1};
        int k2 = 1;
        System.out.println(Arrays.toString(intArray2));
        System.out.println(test.containsNearbyDuplicate(intArray2, k2));

        int[] intArray3 = new int[]{1, 2, 1};
        int k3 = 1;
        System.out.println(Arrays.toString(intArray3));
        System.out.println(test.containsNearbyDuplicate(intArray3, k3));
    }
}
