package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wei
 * @since 12/6/16
 */
public class CombinationSum2 {
    /**
     * Given a collection of candidate numbers (C) and a target number (T),
     * find all unique combinations in C where the candidate numbers sums to T.
     * Each number in C may only be used once in the combination.
     *
     * Note:
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     *
     * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
     * A solution set is:
     * [
     * [1, 7],
     * [1, 2, 5],
     * [2, 6],
     * [1, 1, 6]
     * ]
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combSum(result, new ArrayList<>(), candidates, target);
        return result;
    }

    private void combSum(List<List<Integer>> result, ArrayList<Integer> curList, int[] tail, int rest) {
        if (rest > 0) {
            for (int i = 0; i < tail.length && tail[i] <= rest; i++) {
                if (i >=1 && tail[i] == tail[i - 1]) continue;
                curList.add(tail[i]);
                combSum(result, curList, Arrays.copyOfRange(tail, i + 1, tail.length), rest - tail[i]);
                curList.remove(curList.size() - 1);
            }
        } else if (rest == 0) {
            result.add(new ArrayList<>(curList));
        }
    }

    public static void main(String[] args) {
        int[] arr0 = new int[]{10, 1, 2, 7, 6, 1, 5};
        CombinationSum2 obj = new CombinationSum2();
        System.out.println(obj.combinationSum2(arr0, 8));
    }
}
