class Solution {
    public int numTrees(int n) {
        
        return uniTree(n);

    }

    private int uniTree(int n){
        if(n <= 2){
            if(n == 0){
                return 1;
            }
            return n;
        }
        int count = 0;
        for(int i = 1;i<=n/2;i++){
            int left = i-1;
            int right = n-i;
            
            count += 2*uniTree(left)*uniTree(right);
        }
        if(n % 2 == 1){
            int mid = (n/2)+1;
            count += uniTree(mid-1)*uniTree(n-mid);
        }
        return count;
    }

    
}