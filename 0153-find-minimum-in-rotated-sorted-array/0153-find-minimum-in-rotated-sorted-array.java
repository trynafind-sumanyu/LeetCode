class Solution {
    public int findMin(int[] nums) {
        int piv = pivot(nums);
        if(piv!= -1) return nums[piv+1];
        else return nums[0];
    }
    int pivot(int[] arr){
        int s = 0;
        int e = arr.length -1;
        while (s<e){
            int mid = s+(e-s)/2;
            if (mid<arr.length-1&&arr[mid]>arr[mid+1]){
                return mid;
            }else {
                if (arr[s]<arr[mid]){ //checks whether the mid is in 1st asc part
                    s = mid + 1;
                }else { // whether mid is in 2nd asc part
                    e = mid;
                }
            }
        }
        return -1;
    }
}