class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();

        for(int i : nums1){
            map1.put(i,map1.getOrDefault(i,0)+1);
            map2.put(i,map2.getOrDefault(i,0)+1);
        }
        
        for(int i : nums2){
            map1.put(i,map1.getOrDefault(i,0)-1);
            map2.put(i,map2.getOrDefault(i,0)+1);
        }

        for(int val : map2.values()){
            if(val%2 == 1){
                return -1;
            }
        }

        int ans = 0;

        for(int val : map1.values()){
            ans += Math.abs(val)/2;
        }

        return ans/2;



    }
}