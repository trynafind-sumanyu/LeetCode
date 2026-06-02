class Solution {
    public int earliestTime(int[][] tasks) {
        int min = Integer.MAX_VALUE;
        for(int[] t : tasks ){
            min = Math.min(min,t[0]+t[1]);
        }
        return min;
    }
}