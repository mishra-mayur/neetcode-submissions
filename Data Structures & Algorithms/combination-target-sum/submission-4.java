class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        //initialisation 
        List<List<Integer>> result = new ArrayList();
        List<Integer> current = new ArrayList();

        Arrays.sort(nums);

        backtrack(result, current, nums, target, 0, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int target, int start, int total) {

        // base condition check
        if(total == target) {
            result.add(new ArrayList(current));
        }

        //check all
        for(int i = start; i < nums.length; i++) {
            if(total + nums[i] > target)
                return;
            
            current.add(nums[i]);//add
            backtrack(result, current, nums, target, i, total + nums[i]);//backtrac
            current.remove(current.size() - 1);//remove
        }
    }
}
