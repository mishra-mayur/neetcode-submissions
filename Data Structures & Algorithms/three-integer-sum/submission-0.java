class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet();
        for(int i = 0; i < nums.length; i++) {
            

            int j = i+1, k = nums.length - 1;

            if(i == k || j==k)
                continue;

            while(j < k && j < nums.length) {
                List<Integer> list = new ArrayList();
                if(nums[i] == - nums[j] - nums[k]){
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                    k--;
                } else if (nums[i] < -nums[j] - nums[k]) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return new ArrayList(result);
    }
}
