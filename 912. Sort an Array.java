class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        // Step 1: Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // Step 2: Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root (largest element) to the end
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // Call max heapify on the reduced heap
            heapify(nums, i, 0);
        }

        return nums;
    }

    private void heapify(int[] nums, int heapSize, int rootIdx) {
        int largest = rootIdx; 
        int leftChild = 2 * rootIdx + 1; 
        int rightChild = 2 * rootIdx + 2; 

        // If left child is larger than root
        if (leftChild < heapSize && nums[leftChild] > nums[largest]) {
            largest = leftChild;
        }

        // If right child is larger than the largest so far
        if (rightChild < heapSize && nums[rightChild] > nums[largest]) {
            largest = rightChild;
        }

        // If the largest is not root, swap and continue heapifying
        if (largest != rootIdx) {
            int swap = nums[rootIdx];
            nums[rootIdx] = nums[largest];
            nums[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(nums, heapSize, largest);
        }
    }
}
