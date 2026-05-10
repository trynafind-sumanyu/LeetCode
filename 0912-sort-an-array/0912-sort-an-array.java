class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length);
        return nums;
    }

    private void mergeSort(int[] nums,int s, int e){
        if(e-s == 1){
            return;
        }
        int mid = s + (e-s)/2;

        mergeSort(nums, s, mid);
        mergeSort(nums, mid, e);

        merge(nums, s, mid, e);
    }

    private void merge(int[] nums, int s, int mid, int e){
        int[] merged = new int[e-s];

        int i = s;
        int j = mid;
        int k = 0;

        while(i < mid && j<e){
            if(nums[i] < nums[j]){
                merged[k++] = nums[i++];
            }
            else{
                merged[k++] = nums[j++];
            }
        }

        while(i < mid){
            merged[k++] = nums[i++];
        }

        while(j < e){
            merged[k++] = nums[j++];
        }
        
        System.arraycopy(merged,0,nums,s,merged.length);
    }
}