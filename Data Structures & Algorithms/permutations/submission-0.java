class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        boolean[] chosen = new boolean[nums.length];

        backtrack(result, new ArrayList(), nums, chosen);
        return result;
    }

    private void backtrack(
        List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] chosen) {
        if (current.size() == nums.length) {
            result.add(new ArrayList(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!chosen[i]) {
                current.add(nums[i]);
                chosen[i] = true;
                backtrack(result, current, nums, chosen);
                current.remove(current.size() - 1);
                chosen[i] = false;
            }
        }
    }
}
