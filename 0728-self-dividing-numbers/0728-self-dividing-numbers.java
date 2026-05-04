class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(check(i)){
                ans.add(i);
            }
        }
        return ans;
    }

    boolean check(int n){
        int num = n;
        while(num>0){
            int rem = num%10;
            if(rem == 0 || n%rem != 0){
                return false;
            }
            num /= 10;

        }
        return true;
    }
}