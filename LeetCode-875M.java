class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; 
        int right = 0;
        
        for (int p : piles) {
            right = Math.max(right, p);
        }
        
        int minSpeed = right; 
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (calculateHours(mid, piles) <= h) {
                minSpeed = mid;    
                right = mid - 1;   
            } else {
                left = mid + 1;  
            }
        }
        return minSpeed;
    }

    private long calculateHours(int speed, int[] piles) {
        long totalHours = 0;
        for (int pile : piles) {
            totalHours += (long)(pile + speed - 1) / speed;
        }
        return totalHours;
    }
}