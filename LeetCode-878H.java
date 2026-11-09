
class Solution {
    public int nthMagicalNumber(int n, int a, int b) {

        long st = 1;
        long end = (long) n * Math.min(a, b);
        long lcm = lcm(a, b);
        while (st < end) {
            long mid = st + (end - st) / 2;
            long count = (mid / a) + (mid / b) - (mid / lcm);
            if (count >= n) {
                end = mid;
            }
            else {
                st = mid + 1;
            }
        }
        return (int)(st % 1_000_000_007);
    }
    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
