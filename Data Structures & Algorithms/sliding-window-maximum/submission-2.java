class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.key, a.key)   // Min Heap based on key
        );

        int l = 0;
        for(int r = k-1; r < nums.length; r++, l++) {
            //System.out.println("index r : "+r+" pq : "+pq);
            result[l] = getMax(nums, l, r, pq);
        }
        return result;
    }

    private int getMax(int[] nums, int l, int r, PriorityQueue<Pair> pq) {
        if(l == 0) {
            for(int i = 0; i <= r; i++) {
                pq.offer(new Pair(nums[i], i));
            }
            return pq.peek().key;
        }

        if(!pq.isEmpty() && pq.peek().value <= r && pq.peek().value >= l) {
            pq.offer(new Pair(nums[r],r));
            return pq.peek().key;
        }
        else {
            while(!pq.isEmpty() && pq.peek().value < l) {
                pq.remove();
            }
            pq.offer(new Pair(nums[r],r));
            return pq.peek().key;
        }
    }
}

class Pair {

    int key;
    int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return "{ key : "+key+" , value : "+ value +" }\n";
    }

}
