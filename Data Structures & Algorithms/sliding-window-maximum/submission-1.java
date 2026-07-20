class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(k > nums.length)
            return null;
        
        int size = nums.length - k + 1;
        int[] result = new int[size];
        int l = 0;

        for(int r = k-1; r < nums.length; r++,l++) {
            result[l] = getMax(nums, l, r);
        }

        return result;

    }

    private int getMax(int[] nums, int l, int r) {
        int max = Integer.MIN_VALUE;

        for(int i = l; i <= r; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
