import java.util.Random;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 * @author Wei
 * @since 11/30/15
 *
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if(!set.add(i))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int size = 1000;
        int[] intArray1 = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++)
            intArray1[i] = rand.nextInt(size);

        if (new ContainsDuplicate().containsDuplicate(intArray1))
            System.out.print("The array contains duplicate!\n");

    }
}
