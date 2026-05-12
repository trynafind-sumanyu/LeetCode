class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a,b) -> (b[1]-b[0])-(a[1]-a[0]));

        int curr = 0;
        int initial = 0;

        for(int[] t : tasks){
            int actual = t[0];
            int min = t[1];

            if(curr < min){
                initial += min - curr;
                curr = min;
            }
            curr -= actual;
        }
        return initial;
    }
}