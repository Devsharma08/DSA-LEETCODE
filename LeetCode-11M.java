class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1 ;
        int maxArea = 0 ;

        while (left < right) {
            int minHt = (height[right] > height[left]) ? height[left] : height[right];
            maxArea = (maxArea > minHt * (right - left)) ? maxArea : minHt * (right - left);

            while( left < right && minHt >= height[left]) left++;
            while( left < right && minHt >= height[right]) right--;

        }
            return maxArea;
    }
}