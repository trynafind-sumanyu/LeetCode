class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        List<Integer> f = new ArrayList<>();

        for(int[] row:factory){
            for(int i = 1;i<=row[1];i++){
                f.add(row[0]);
            }
        }
        Collections.sort(f);
        Collections.sort(robot);

        long[] curr = new long[f.size()+1];
        long[] next = new long[f.size()+1];

        curr[f.size()] = (long)1e12;

        for(int i = robot.size()-1;i>=0;i--){
            for(int j = f.size()-1;j>=0;j--){
                long a = Math.abs((long)robot.get(i)-(long)f.get(j)) + next[j+1];
                long skip = curr[j+1];
                curr[j] = Math.min(a,skip);
            }
            System.arraycopy(curr, 0, next, 0, f.size() + 1);
        }
        return curr[0];

    }
}