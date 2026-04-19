class Solution {
    public int maxDistance(int[] a, int[] b) {
        int n = a.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            int idx = ub(b, a[i], i, b.length) - 1;

            if (idx >= i) {
                max = Math.max(max, idx - i);
            }
        }
        return max;
    }

    public int ub(int[] arr, int target, int s, int e) {
        while (s < e) {
            int mid = s + (e - s) / 2;

            if (arr[mid] >= target) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }
}