package array;

import java.util.*;

/**
 * @author Wei
 * @since 12/6/16
 */
public class CombinationSum {
    /**
     * Given a set of candidate numbers (C) and a target number (T),
     * find all unique combinations in C where the candidate numbers sums to T.
     * <p>
     * The same repeated number may be chosen from C unlimited number of times.
     * <p>
     * Note:
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * <p>
     * For example, given candidate set [2, 3, 6, 7] and target 7,
     * A solution set is:
     * [
     * [7],
     * [2, 2, 3]
     * ]
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        combSum(result, new ArrayList<>(), candidates, target);
        return result;
    }

    private void combSum(List<List<Integer>> result, ArrayList<Integer> curList, int[] tail, int rest) {
        if (rest > 0) {
            for (int i = 0; i < tail.length && tail[i] <= rest; i++) {
                curList.add(tail[i]);
                combSum(result, curList, Arrays.copyOfRange(tail, i, tail.length), rest - tail[i]);
//                curList.remove(curList.size() - 1);
            }
        } else if (rest == 0) {
            result.add(new ArrayList<Integer>(curList));
        }
    }

    public static void main(String[] args) {
        int[] arr0 = new int[]{2, 3, 6, 7};
        CombinationSum obj = new CombinationSum();
        System.out.println(obj.combinationSum(arr0, 6));
    }
}

