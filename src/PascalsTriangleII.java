import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p>
 * For example, given k = 3,
 * Return [1,3,3,1].
 * <p>
 * Note:<br>
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * @author Wei
 * @since 2/15/16
 */
public class PascalsTriangleII {

    // traditional way with O(n) space
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            row.add(1);
            for (int j = i - 1; j > 0; j--) { row.set(j, row.get(j - 1) + row.get(j)); }
        }
        return row;
    }

    // mathematical way using combination calculation with O(n) time and O(1) space
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);

        long number = 1;
        int i;
        // 1st part of the loop: combination calculation
        for (i = 0; i <= rowIndex / 2; i++) {
            row.add(Math.toIntExact(number));
            number *= rowIndex - i;     // compute the next element [i+1]: C(rowIndex, i) = C(rowIndex, i-1) * (rowIndex-i+1 / i)
            number /= i + 1;            // 2 steps to avoid float multiplication
        }
        // 2nd part of the loop: mirror the 1st part
        for (; i <= rowIndex; i++) { row.add(row.get(rowIndex - i)); }
        return row;
    }

    public static void main(String[] args) {
        PascalsTriangleII test = new PascalsTriangleII();

        System.out.println(test.getRow1(10).toString());
    }

}
