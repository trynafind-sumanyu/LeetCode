class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n+1];
        List<Integer> list = new ArrayList<>();
        fact[0] = 1;
        for(int i = 1;i<=n;i++){
            list.add(i);
            fact[i] = i*fact[i-1];
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for(int i = n;i>0;i--){
            int index = k/fact[i-1];
            sb.append(list.get(index));
            list.remove(index);
            k %= fact[i-1];
        }
        return sb.toString();
    }
}