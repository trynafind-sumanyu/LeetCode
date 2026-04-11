class Solution {
    public boolean uniformArray(int[] arr) {
        int n = arr.length;
        int min = arr[0];
        boolean even = true;
        for(int i : arr){
            min = Math.min(min,i);
            if(i%2 == 1){
                even = false;
            }
        }

        return (min%2 == 1) || even;


    }
}