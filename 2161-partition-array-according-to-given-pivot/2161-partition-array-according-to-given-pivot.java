class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> p = new ArrayList<>();

        for(int i : nums){
            if(i < pivot){
                l1.add(i);
            }
            else if(i > pivot){
                l2.add(i);
            }
            else {
                p.add(i);
            }
        }

        int n = nums.length;
        int index = 0;
        for(int i = 0;i<l1.size();i++){
            nums[index++] = l1.get(i);
        }

        for(int i = 0;i<p.size();i++){
            nums[index++] = p.get(i);
        }

        for(int i = 0;i<l2.size();i++){
            nums[index++] = l2.get(i);
        }

        return nums;

    }
}