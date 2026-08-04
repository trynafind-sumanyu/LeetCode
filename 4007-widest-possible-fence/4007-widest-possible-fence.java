class Solution {
    public int maximumWidth(int[] p) {
        int n = p.length;
        Map<Integer,Integer> c = new HashMap<>();
        Map<Integer,Integer> res = new HashMap<>();

        for(int i : p){
            c.put(i,c.getOrDefault(i,0)+1);
            res.put(i,res.getOrDefault(i,0)+1);
        }

        for(int i : c.keySet()){
            for(int j : c.keySet()){
                if(i < j){
                    res.put(i+j,res.getOrDefault(i+j,0)+Math.min(c.get(i),c.get(j))); 
                }
                if(i == j){
                    res.put(i+j,res.getOrDefault(i+j,0)+c.get(i)/2);
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i : res.values()){
            max = Math.max(i,max);
        }

        return max;
    }
}