class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = i+1;

        while(i<j) {
            if(target == nums[i]+nums[j])
                return new int[]{i,j};
            if(j!=nums.length - 1)
                j++;
            else {
                i++;
                if(i!= nums.length -1)
                    j = i+1;
            }
        }
        return new int[]{i,j};
    }
}
