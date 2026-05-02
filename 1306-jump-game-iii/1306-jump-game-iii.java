class Solution {
    boolean[] check;

    public boolean canReach(int[] arr, int start) {
        check = new boolean[arr.length];
        Arrays.fill(check, false);
        int n = arr.length;

        boolean zero = false;
        for (int i : arr) {
            if (i == 0) {
                zero = true;
            }
        }
        if (!zero) {
            return false;
        }

        return helper(arr, start);
    }

    private boolean helper(int[] arr, int s) {
        if(s > arr.length-1 || s < 0){
            return false;
        }
        if (arr[s] == 0) {
            return true;
        }
        if (check[s]) {
            return false;
        }
        int i = s;

        if (i - arr[i] < 0) {
            check[i] = true;
            return helper(arr, i + arr[i]);
        }
        else if (i + arr[i] > arr.length - 1) {
            check[i] = true;
            return helper(arr, i - arr[i]);
        }
        else {
            check[i] = true;
            return helper(arr, i + arr[i]) || helper(arr, i - arr[i]);
        }
    }
}