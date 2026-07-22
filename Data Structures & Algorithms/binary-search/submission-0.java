class Solution {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length -1;
        return binarySearch(nums, target, i, j);
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        if(nums[start] == target)
            return start;

        if(nums[end] == target)
            return end;

        int mid = start+(end-start)/2;

        if(start == mid || end == mid)
            return -1;

        if(target == nums[mid])
            return mid;
        else if(target < nums[mid]) {
            return binarySearch(nums, target, start, mid);
        } else {
            return binarySearch(nums, target, mid, end);
        }
        
    }
}
