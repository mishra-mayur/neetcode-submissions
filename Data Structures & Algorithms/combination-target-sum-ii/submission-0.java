class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList();
        List<Integer> current = new ArrayList();

        Arrays.sort(candidates);

        backtrack(result, current, candidates, target, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int index) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // Since array is sorted, no future value can work
            if (candidates[i] > target)
                break;

            // Skip duplicates at the same recursion level
            if (i > index && candidates[i] == candidates[i - 1])
                continue;

            current.add(candidates[i]);

            // i + 1 because each number can be used only once
            backtrack(
                result,
                current,
                candidates,
                target - candidates[i],
                i + 1
            );

            current.remove(current.size() - 1);
        }

    }
}
