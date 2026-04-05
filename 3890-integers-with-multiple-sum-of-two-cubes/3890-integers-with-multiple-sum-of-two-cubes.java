class Solution {
    public List<Integer> findGoodIntegers(int n) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int a = 1;a*a*a <= n;a++){
            for(int b = a;b*b*b <= n;b++){
                int sum = a*a*a + b*b*b;
                if(sum <= n){
                    map.put(sum,map.getOrDefault(sum,0)+1);
                }
            }
        }

        for(int key : map.keySet()){
            if(map.get(key) >1){
                ans.add(key);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}