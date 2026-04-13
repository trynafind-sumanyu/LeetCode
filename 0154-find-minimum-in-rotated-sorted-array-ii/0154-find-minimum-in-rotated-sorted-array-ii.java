class Solution {
    public int findMin(int[] nums) {
        int piv = pivotDuplicate(nums);
        if(piv!=-1){
            return nums[piv+1];
        }else {
            return nums[0];
        }
    }
    int pivotDuplicate(int[] arr) {
        int s = 0;
        int e = arr.length - 1;

        while (s < e) {
            int mid = s + (e - s) / 2;
            if (arr[s] == arr[mid] && arr[mid] == arr[e]){ //checks for whether s,e,mid are equal(duplicates)
                //what if start is pivot?
                if(arr[s]>arr[s+1]){ //checks whether the start is pivot and returning it before neglecting it
                 return s;
                }
                s = s + 1; //if not, then update the start

                //what if end is pivot?
                if(arr[e-1]>arr[e]){ // checks whether the end is pivot and returning it before neglecting it
                    return e-1;
                }
                e = e - 1; //if not, then update the end and shrink the array
            }
            else if (mid<arr.length-1&&arr[mid] > arr[mid + 1]) {
                return mid;
            } else {
                if (arr[s] <= arr[mid]) { //checks whether the mid is in 1st asc part
                    s = mid + 1;
                } else { // whether mid is in 2nd asc part
                    e = mid;
                }
            }
        }
        return -1;
    }
}