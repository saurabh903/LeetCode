class Solution {
    public int minSwaps(int[] nums) {
        int count1 = 0;
        int n = nums.length;
        int max1 = 0;
        int k = (int) Arrays.stream(nums).filter(a -> a == 1).count();

        for(int i = 0; i<n*2; i++){
            if(i>=k && nums[(i-k)%n] == 1)
            --count1;
            if (nums[i % n] == 1)
            ++count1;
            max1 = Math.max(max1, count1);

        }

        return k-max1;

        
    }
}