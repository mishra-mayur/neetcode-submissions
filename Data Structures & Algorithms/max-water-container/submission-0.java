class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int i = 0, j = heights.length-1;
        while(i < j) {
            maxArea = Math.max(maxArea,Math.min(heights[i],heights[j])*(j-i));
            j--;
            if(j==i && i != heights.length - 1) {
                i++;
                j = heights.length -1;
            }
        }
        return maxArea;
    }
}
