class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int currCon = 0;
        int totalCon = 0;
        int start = 0;
        for(int i = 0 ;i<n;i++){
            int consume = gas[i] - cost[i];
            currCon += consume;
            totalCon += consume;

            if(currCon < 0){
                currCon = 0;
                start = i+1;
            }
        }
        return totalCon < 0 ? -1 : start;
    }
}