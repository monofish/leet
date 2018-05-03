import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * For example, given numRows = 5,
 * Return
 * <p>
 * [<br>
 *     [1],<br>
 *    [1,1],<br>
 *   [1,2,1],<br>
 *  [1,3,3,1],<br>
 * [1,4,6,4,1]<br>
 * ]
 *
 * @author Wei
 * @since 2/15/16
 */
public class PascalsTriangle {
    // O(n^2)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rowlist = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) row.add(1);
                else { row.add(rowlist.get(i - 1).get(j - 1) + rowlist.get(i - 1).get(j)); }
            }
            rowlist.add(row);
        }
        return rowlist;
    }

    // a concise implementation but no big difference on performance
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> rowlist = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(1);
            for (int j = i - 1; j > 0; j--) { row.set(j, row.get(j - 1) + row.get(j)); }
            rowlist.add(new ArrayList<>(row));
        }
        return rowlist;
    }

    public static void main(String[] args) {
        PascalsTriangle test = new PascalsTriangle();

        List<List<Integer>> tri = test.generate1(5);
        for (List<Integer> row : tri) System.out.println(row.toString());
    }
}
