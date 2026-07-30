class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MIN_VALUE;
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;

        for(int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        return binarySearch(piles, h, 1, max, min);

    }

    private int binarySearch(int[] piles, int h, int start, int end, int[] min) {

        int mid = start + (end - start)/2;

        System.out.println("Piles : "+Arrays.toString(piles)+" h : "+h+" start : "+start+" mid : "+mid+" end : "+end+" min : "+min[0]);

        
        if(start > end) {
           
            return min[0];
        }
            

        if(kokoCanEat(piles, mid, h)) {
            min[0] = min[0] < mid ? min[0] : mid;
            return binarySearch(piles, h, start, mid - 1, min);
        } else {
            return binarySearch(piles, h, mid+ 1, end, min);
        }
        
    }

    private boolean kokoCanEat(int[] piles, int k, int h) {
        int sum = 0;
        for(int i = 0; i < piles.length; i++) {
            sum += (piles[i] + k - 1)/k;
        }
        return sum <= h;
    }
}
