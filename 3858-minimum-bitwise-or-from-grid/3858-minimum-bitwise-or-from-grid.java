class Solution {
        public int minimumOR(int[][] grid) {
        int res = 0;
        for (int bi = 20; bi >= 0; --bi) {
            int b = 1 << bi;
            int mask = res | (b - 1);
            for (int[] r : grid) {
                boolean bad = true;
                for (int a : r) {
                    if ((a & mask) == a) {
                        bad = false;
                        break;
                    }
                }
                if (bad) {
                    res |= b;
                    break;
                }
            }
        }
        return res;
    }
}