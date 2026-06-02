class Solution {
    public int earliestFinishTime(int[] ls, int[] ld, int[] ws, int[] wd) {
        int ans = Integer.MAX_VALUE;
        int l = ls.length;
        int w = ws.length;
        for (int i = 0; i < l; i++) {

            for (int j = 0; j < w; j++) {
                int t = 0;
                if (ls[i] <= ws[j]) {
                    t += ls[i] + ld[i];
                    if (t >= ws[j]) {
                        t += wd[j];
                    }
                    else {
                        t += ws[j]-t;
                        t += wd[j];
                    }
                }
                else {
                    t += ws[j] + wd[j];
                    if (t >= ls[i]) {
                        t += ld[i];
                    }
                    else {
                        t += (ls[i]-t);
                        t += ld[i];
                    }
                }
                ans = Math.min(ans, t);
            }
        }
        return ans;
    }
}