import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:<br>
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 * @author Wei
 * @since 2/15/16
 */
public class MergeSortedArray {
    /**
     * @param nums1 sorted integer array A which has m elements,
     *              but size of A is m+n
     * @param nums2 sorted integer array B which has n elements
     * @return: void
     */
    // the traditional way needs to copy the whole array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] aux1 = Arrays.copyOf(nums1, m + n);

        int i = 0;
        int j = 0;
        for (int k = 0; k < m + n; k++) {
            if (i >= m) nums1[k] = nums2[j++];
            else if (j >= n) nums1[k] = aux1[i++];
            else if (aux1[i] > nums2[j]) nums1[k] = nums2[j++];
            else nums1[k] = aux1[i++];
        }

//        while (n > 0) nums1[m + n - 1] = (m <= 0 || nums2[n - 1] > nums1[m - 1]) ? nums2[--n] : nums1[--m];
    }

    // a faster, concise, in-place solution starting from the end of array -- "blank" area
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // loop condition has to be about n (array B),
        // because when n decrements to 0, elements in A remain in A,
        // but if m decrements to 0, loop ends and elements in B are left in B.
        while (n > 0) A[m + n - 1] = (m <= 0 || B[n - 1] > A[m - 1]) ? B[--n] : A[--m];
    }

    public static void main(String[] args) {
        MergeSortedArray test = new MergeSortedArray();

        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        test.mergeSortedArray(nums1, m, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }
}
