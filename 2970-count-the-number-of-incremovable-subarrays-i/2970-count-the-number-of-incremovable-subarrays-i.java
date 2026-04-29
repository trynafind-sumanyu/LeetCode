class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                List<Integer> list = new ArrayList<>();
                for(int k = 0;k<n;k++){
                    if(k >= i && k <= j){
                        continue;
                    }
                    else{
                        list.add(nums[k]);
                    }
                }
                if(check(list)){
                    ans++;
                }
            }
        }
        return ans;
    }

    boolean check(List<Integer> list){

        for(int i = 0;i<list.size()-1;i++){
            if(list.get(i) >= list.get(i+1)){
                return false;
            }
        }
        return true;
    }
}