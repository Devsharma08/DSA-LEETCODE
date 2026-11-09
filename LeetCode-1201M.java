
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {

        long st = 1;
        long min = Math.min(a, Math.min(b, c));
        long end = (long) n * min;

        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ac = lcm(a, c);
        long abc = lcm(a, bc);

        while (st < end) {

            long mid = st + (end - st) / 2;

            long count = (mid / a) + (mid / b) + (mid / c)
                       - (mid / ab) - (mid / bc) - (mid / ac)
                       + (mid / abc);

            if (count >= n) {
                end = mid;
            } else {
                st = mid + 1;
            }
        }

        return (int) st;
    }

    public static long lcm(long a, long b) {
        return (a / hcf(a, b)) * b;
    }

    public static long hcf(long a, long b) {
        if (b == 0) return a;
        return hcf(b, a % b);
    }
}
