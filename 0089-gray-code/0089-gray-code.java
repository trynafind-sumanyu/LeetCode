class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<(int)Math.pow(2,n);i++){
            ans.add(toGrayCode(i));
        }
        return ans;
    }

    private int toGrayCode(int a){
        return a^(a>>1);
    }
}