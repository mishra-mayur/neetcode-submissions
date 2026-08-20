class Solution {
    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        return canJump(nums, 0, memo);
    }

    private boolean canJump(int[] nums, int start, int[] memo) {
        if(start == nums.length -1)
            return true;
        
        if(nums[start] == 0)
            return false;
        
        if(memo[start] == 1)
            return true;
        
        if(memo[start] == 2)
            return false;
        
        boolean result = false;

        for(int i = 1; i <= nums[start]; i++) {
            result = result || canJump(nums, start + i, memo);
        }
        memo[start] = result ? 1 : 2;
        return result;
    }
}
