package leetcodeHot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 组合总和:
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 * <p>
 * 示例1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> trace = new ArrayDeque<>();
        int length = candidates.length;
        if (length == 0 || (length == 1 && candidates[0] > target)) {
            return result;
        }
        backtrace(result, trace, length, target, candidates, 0);
        return result;
    }

    public void backtrace(List<List<Integer>> result, Deque<Integer> trace, int length, int target, int[] candidates, int index) {
        // 结束条件
        if (trace.stream().mapToInt(item -> item).sum() == target) {
            result.add(new ArrayList<>(trace));
            return;
        }
        if (trace.stream().mapToInt(item -> item).sum() > target) {
            return;
        }
        for (int i = index; i < length; i++) {
            int num = candidates[i];
            trace.addLast(num);
            backtrace(result, trace, length, target, candidates, i);
            trace.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(candidates, target));
        candidates = new int[]{1};
        target = 2;
        //System.out.println(combinationSum.combinationSum(candidates, target));
    }
}
