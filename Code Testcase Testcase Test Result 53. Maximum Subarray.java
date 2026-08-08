class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Decide to extend the current subarray or start a new one
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            // Keep track of the overall maximum sum encountered
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        
        return maxSoFar;
    }
}
