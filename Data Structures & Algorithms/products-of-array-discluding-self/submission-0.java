class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        Arrays.fill(prefix,1);
        Arrays.fill(suffix,1);

        prefix[1] = nums[0];
        for(int i = 2; i < nums.length; i++) {
            prefix[i] = prefix[i-1]*nums[i-1];
        }

        suffix[nums.length - 2] = nums[nums.length - 1];
        for(int i = nums.length - 3; i >=0 ; i--) {
            suffix[i] = suffix[i+1]*nums[i+1];
        }

        // System.out.println(Arrays.toString(prefix));
        // System.out.println(Arrays.toString(suffix));

        int[] result = new int[nums.length];
        for(int i = 0; i< nums.length; i++) {
            result[i] = prefix[i]*suffix[i];
        }
        return result;
    }
}  
