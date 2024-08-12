class KthLargest {
    PriorityQueue<Integer> pq;
    int K;

    public KthLargest(int k, int[] nums) {
        K= k;
        pq = new PriorityQueue<Integer>(K);

        for(int num : nums){
            pq.offer(num);
            if(pq.size() > K){
                pq.poll();
            }
        }
        
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > K){
            pq.poll();

        }

return pq.peek();

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */