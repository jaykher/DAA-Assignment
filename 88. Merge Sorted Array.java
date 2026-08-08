class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointer for the last element of the initial values in nums1
        int p1 = m - 1;
        // Pointer for the last element in nums2
        int p2 = n - 1;
        // Pointer for the position where the next largest element will go in nums1
        int pMerged = m + n - 1;
        
        // Compare elements from the back of both arrays and place the larger one
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[pMerged] = nums1[p1];
                p1--;
            } else {
                nums1[pMerged] = nums2[p2];
                p2--;
            }
            pMerged--;
        }
        
        // If there are remaining elements in nums2, copy them over
        // (Note: If p1 >= 0, they are already in their correct places in nums1)
        while (p2 >= 0) {
            nums1[pMerged] = nums2[p2];
            p2--;
            pMerged--;
        }
    }
}
