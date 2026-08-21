class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;

        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);

        return jumps(nums, 0, arr);
    }

    private int jumps(int[] nums, int start, int[] arr) {
        if (start == nums.length - 1)
            return 0;

        if (nums[start] == 0)
            return Integer.MAX_VALUE;
        
        if(arr[start] != -1)
            return arr[start];

        int end = Math.min(start + nums[start], nums.length - 1);

        int minJump = Integer.MAX_VALUE;

        for (int i = start + 1; i <= end; i++) {
            int result = jumps(nums, i, arr);

            if (result != Integer.MAX_VALUE) {
                minJump = Math.min(minJump, result);
            }
        }

        if (minJump == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        arr[start] = minJump + 1;
        return minJump + 1;
    }
}