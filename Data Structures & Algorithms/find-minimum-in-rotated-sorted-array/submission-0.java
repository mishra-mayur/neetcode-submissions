class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;

        return binarySearch(nums, min, start, end);
    }

    private int binarySearch(int[] nums, int[] min, int start, int end) {
        if (start > end)
            return min[0];

        int mid = start + (end - start) / 2;

        if (min[0] > nums[mid])
            min[0] = nums[mid];

        min[0] = Math.min(
            binarySearch(nums, min, start, mid - 1), binarySearch(nums, min, mid + 1, end));

        return min[0];
    }
}
