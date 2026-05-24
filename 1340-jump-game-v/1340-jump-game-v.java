//Approach 1 Recursion + Memo -> TopDown Approach

// T.C. = for every n -> O(n) we traverse 2d indices hence -----> O(n*2*d) == O(n*d)
// S.C. = One 1-d array ----------------------------------------------------> O(n)

class Solution {

    private int[] dp;// Why 1-d array -> only one parameter changed -> index i hence 1-d array

    public int maxJumps(int[] arr, int d) {

        int n = arr.length;
        int result = 1;

        dp = new int[n];
        Arrays.fill(dp,-1);

        for(int i = 0;i<n;i++){
            result = Math.max(result,solve(arr,i,d));
        }

        return result;
    }

    private int solve(int[] arr,int i, int d){

        //If memorized value occured return it.
        if(dp[i] != -1){
            return dp[i];
        }

        int result = 1;

        //left side
        for(int j = i-1;j >= Math.max(0,i-d);j--){
            if(arr[j] >= arr[i]){
                break;
            }
            result = Math.max(result,1+solve(arr,j,d));
        }

        //right side
        for(int j = i+1;j <= Math.min(arr.length-1,i+d);j++){
            if(arr[j] >= arr[i]){
                break;
            }
            result = Math.max(result,1+solve(arr,j,d));
        }

        //Memorization happens here
        return dp[i] = result;
    }

}