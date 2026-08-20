class Solution {
    public boolean canJump(int[] nums) {
        // reverse thinking

        // starting from back, trying to reach 0th index
        // if we can reach other index we will keep updating goal
        int goal = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--) {
            if(i + nums[i] >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }
}
