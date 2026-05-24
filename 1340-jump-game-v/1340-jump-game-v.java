//Approach 2 Bottom Up 

// T.C. = for every n -> O(n) we traverse 2d indices hence -----> O(n*2*d) == O(n*d)
// S.C. = One 1-d array ----------------------------------------------------> O(n)

class Solution {

    private int[] dp;// Why 1-d array -> only one parameter changed -> index i hence 1-d array

    public int maxJumps(int[] arr, int d) {

        int n = arr.length;

        int[][] sortArr = new int[n][2];

        for(int i = 0;i<n;i++){
            sortArr[i][0] = arr[i];
            sortArr[i][1] = i;
        }

        Arrays.sort(sortArr, (a,b) -> Integer.compare(a[0], b[0])); //Sorting based on elements in arr with their respective index value

        dp = new int[n];
        Arrays.fill(dp,-1);

        for(int[] a : sortArr){

            int result = 1;
            int e = a[0];
            int i = a[1];

            //left side
            for(int j = i-1;j >= Math.max(0,i-d);j--){
                if(arr[j] >= arr[i]){
                    break;
                }
                result = Math.max(result,1+dp[j]);
            }

            //right side
            for(int j = i+1;j <= Math.min(arr.length-1,i+d);j++){
                if(arr[j] >= arr[i]){
                    break;
                }
                result = Math.max(result,1+dp[j]);
            }

            //Storing Result for each i
            dp[i] = result;
        }

        //After filling up find the max value got from an index
        int max = 1;
        for(int i : dp){
            max = Math.max(max,i);
        }

        return max;
    }
}