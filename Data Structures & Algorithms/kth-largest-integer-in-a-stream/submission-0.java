class KthLargest {
    PriorityQueue<Integer> pq = null;
    int size = 0;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue(k);
        size = k;
        for (int i = 0; i < nums.length; i++) {
            //System.out.println(pq);
            if (pq.isEmpty() || pq.size() < k) {
                pq.add(nums[i]);
            } else {
                if (pq.peek() <= nums[i]) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
    }

    public int add(int val) {
        //System.out.println(pq);
        if (pq.isEmpty() || pq.size() < size) {
            pq.add(val);
        } else {
            if (pq.peek() <= val) {
                pq.poll();
                pq.add(val);
            }
        }
        return pq.peek();
    }
}
