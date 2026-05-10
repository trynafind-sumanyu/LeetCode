import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = queries.length;

        int[] ans = new int[n];
        int i = 0;
        for(int[] q : queries){
            ans[i++] = helper(nums,q[0],q[1]);
        }
        return ans;
    }

    private int helper(String[] nums,int k, int t){
        String[] num = new String[nums.length];

        for(int i = 0; i < nums.length; i++){
            num[i] = nums[i].substring(nums[i].length()-t);
        }
        return kthSmallest(num,k);
    }

    private int kthSmallest(String[] arr, int k) {

        List<SimpleEntry<String,Integer>> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            list.add(new SimpleEntry<>(arr[i],i));
        }
        list.sort((a, b) -> a.getKey().compareTo(b.getKey()));
        return list.get(k-1).getValue();
    }
}