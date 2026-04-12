class Solution {
    public int maxValue(int[] nums1, int[] nums0) {
        int n = nums1.length;
        int MOD = (int) 1e9 + 7;
        String[] segments = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.repeat('1', nums1[i]);
            sb.repeat('0', nums0[i]);
            segments[i] = sb.toString();
        }

        Arrays.sort(segments,(a,b) -> (b+a).compareTo(a+b));

        long res = 0;

        for (String s : segments) {
            for (char ch : s.toCharArray()) {
                res = (res * 2 + (ch - '0')) % MOD;
            }
        }
        return (int) res;
    }
}