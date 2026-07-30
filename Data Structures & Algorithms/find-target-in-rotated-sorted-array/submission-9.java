class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        int def = findDeflection(nums);

        if (def == -1)
            return binarySearch(nums, target, 0, nums.length - 1);
            
        if (target >= nums[0] && target <= nums[def])
            return binarySearch(nums, target, 0, def);

        return binarySearch(nums, target, def + 1, nums.length - 1);
    }

    private int findDeflection(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1])
                return mid;

            if (nums[mid] > nums[end])
                start = mid + 1;
            else
                end = mid;
        }
        return -1;
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        int i = start, j = end;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }
}
