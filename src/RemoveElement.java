import java.util.Arrays;
import java.util.Random;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * @author Wei
 * @since 2/15/16
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int n : nums) {
            if (n != val) nums[i++] = n;    // replace next element [i] with next element n where n != val
        }
        return i;
    }

    // An experiment
    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int n : nums) {
            if (n != val) {
                if (nums[i] != n) nums[i] = n;    // proven not necessary and time-wasting
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {

        int size = 10;
        int[] nums1 = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++)
            nums1[i] = rand.nextInt(size);

        int[] nums2 = Arrays.copyOf(nums1, nums1.length);

        int val = 5;

//        int[] nums1 = {1, 2, 3, 4, 5, 5, 5, 6, 7};

//        System.out.println(test.removeElement(nums1, 5));
//        System.out.println(Arrays.toString(nums1));

        RemoveElement test = new RemoveElement();

        long startTime = System.nanoTime();
        int range = test.removeElement(nums1, val);
        long endTime = System.nanoTime();
        System.out.println(Arrays.toString(Arrays.copyOf(nums1, range)));
        System.out.println(endTime - startTime);

        long startTime2 = System.nanoTime();
        int range2 = test.removeElement1(nums2, val);
        long endTime2 = System.nanoTime();
        System.out.println(Arrays.toString(Arrays.copyOf(nums2, range2)));
        System.out.println(endTime2 - startTime2);


    }
}
