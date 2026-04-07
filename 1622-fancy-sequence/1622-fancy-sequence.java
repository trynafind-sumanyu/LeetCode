class Fancy {
    private List<Long> list;
    private long gAdd = 0;
    private long gMult = 1;
    private long MOD = 1_000_000_000+7;
    public Fancy() {
        list = new ArrayList<>();
    }

    private long modPow(long x, long y, long mod) {
        long res = 1;
        x = x % mod;
        while (y > 0) {
            if (y % 2 == 1) {
                res = (res * x) % mod;
            }
            y = y / 2;
            x = (x * x) % mod;
        }
        return res;
    }
    
    public void append(int val) {
        long temp = (val-gAdd + MOD)%MOD;
        list.add((temp*modPow(gMult,MOD-2,MOD))%MOD);
    }
    
    public void addAll(int inc) {
        gAdd = (gAdd+inc)%MOD;
    }
    
    public void multAll(int m) {
        gMult = (gMult*m)%MOD;
        gAdd = (gAdd*m)%MOD;
    }
    
    public int getIndex(int idx) {
        if(idx >= list.size()){
            return -1;
        }
        return (int)((list.get(idx)*gMult + gAdd)%MOD);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */