class Solution {
    public void rotate(int[] nums, int k) {
        if(k==0||nums.length==1||nums.length==0||k==nums.length){
        }else{
        rev(nums, 0, nums.length-1);
        rev(nums, 0, (k%nums.length)-1);
        rev(nums, k%nums.length, nums.length-1);
        }
    }
    void rev(int[] arr,int start, int end){
        for(int i=start;i<=(end+start)/2;i++){
            int temp = arr[i];
            arr[i]=arr[end+start-i];
            arr[end+start-i]=temp;
        }
    }
}