class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0, high = n1;

        while (low <= high) {
            int i = low + (high - low) / 2;
            int j = (n1 + n2 + 1) / 2 - i;

            int L1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int R1 = (i == n1) ? Integer.MAX_VALUE : nums1[i];

            int L2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int R2 = (j == n2) ? Integer.MAX_VALUE : nums2[j];

            if (L1 <= R2 && L2 <= R1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else {
                    return Math.max(L1, L2);
                }
            } else if (L1 > R2) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }
        return 0.0;
    }
}