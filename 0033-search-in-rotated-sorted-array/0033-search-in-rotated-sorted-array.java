class Solution {
    public int search(int[] nums, int target) {
        int pivot = pivot(nums);
        int ans = binarySearch(nums,target,0,pivot);
        if (ans != -1){
            return ans;
        }else {
            return binarySearch(nums,target,pivot+1,nums.length-1);
        }
    }
    int binarySearch(int[]arr, int target,int s,int e){
        while (s<=e){
            int m = s+(e-s)/2;
            if (arr[m]==target){
                return m;
            }else if (arr[m]<target){
                s = m + 1;
            }else {
                e = m - 1;
            }
        }
        return -1;
    }

    int pivot(int[] arr){
         int s = 0;
        int e = arr.length -1;
        while (s<e){
            int mid = s+(e-s)/2;
            if(arr[mid]>arr[mid+1]){
                return mid;
            }else {
                if (arr[s]>arr[mid]){
                    e = mid;
                }else {
                    s = mid+1;
                }
            }
        }
        return s;
    }
}