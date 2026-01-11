class Solution {
    public int firstMissingPositive(int[] nums) {
        int size = nums.length;
        boolean[] arr = new boolean[size + 1];

        for (int x : nums) {
            if (x >= 1 && x <= size) {
                arr[x] = true;
            }
        }

        for (int i = 1; i <= size; i++) {
            if (!arr[i]) {
                return i;
            }
        }

        return size + 1;
    }
}
