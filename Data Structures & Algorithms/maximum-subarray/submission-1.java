class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curSum = 0;

        for(int i = 0; i < nums.length; i++) {
            if(curSum < 0)
                curSum = 0;

            curSum += nums[i];
            max = Math.max(max, curSum);
        }
        return max;
    }
}
