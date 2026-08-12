class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet();
        List<Integer> current = new ArrayList();

        Arrays.sort(nums);

        backtrack(result, current, nums, 0);
        return new ArrayList(result);
    }

    private void backtrack(Set<List<Integer>> result, List<Integer> current, int[] nums, int start) {

        result.add(new ArrayList(current));

        for(int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(result, current, nums, i+1);
            current.remove(current.size() - 1);
        }
    }
}
