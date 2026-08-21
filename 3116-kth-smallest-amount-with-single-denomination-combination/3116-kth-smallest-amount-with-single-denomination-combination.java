import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
/**
 * LeetCode 3116 - Kth Smallest Amount With Single Denomination Combination
 *
 * Binary search on the answer + inclusion-exclusion over subset LCMs.
 *
 * Time:  O(2^n * n) to precompute subsets, then O(2^n * log(min*k)) for the search.
 * Space: O(2^n).
 */
class Solution {
 
    public long findKthSmallest(int[] coins, int k) {
        // 1) A coin that is a multiple of another coin contributes nothing new.
        //    [3, 6, 9] -> [3].  This keeps n <= 13 in the worst case.
        Arrays.sort(coins);
        List<Integer> base = new ArrayList<>();
        for (int c : coins) {
            boolean redundant = false;
            for (int b : base) {
                if (c % b == 0) {
                    redundant = true;
                    break;
                }
            }
            if (!redundant) base.add(c);
        }
 
        int n = base.size();
        long lo = 1;
        // The smallest coin alone yields min, 2*min, ..., k*min -> count(min*k) >= k.
        long hi = (long) base.get(0) * k;
 
        // 2) Precompute (lcm, sign) for every non-empty subset.
        //    Subsets whose lcm exceeds hi always contribute 0, so skip them.
        long[] lcms = new long[1 << n];
        int[] signs = new int[1 << n];
        int m = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            long l = 1;
            for (int i = 0; i < n; i++) {
                if ((mask >> i & 1) == 1) {
                    int c = base.get(i);
                    l = l / gcd(l, c) * c;   // divide first: no intermediate overflow
                    if (l > hi) break;
                }
            }
            if (l <= hi) {
                lcms[m] = l;
                signs[m] = (Integer.bitCount(mask) % 2 == 1) ? 1 : -1;
                m++;
            }
        }
 
        // 3) Smallest x such that count(x) >= k.
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long cnt = 0;
            for (int i = 0; i < m; i++) {
                cnt += signs[i] * (mid / lcms[i]);
            }
            if (cnt >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
 
    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}