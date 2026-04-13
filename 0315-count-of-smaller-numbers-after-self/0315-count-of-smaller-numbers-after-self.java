public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : sorted) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }
        int[] BIT = new int[rank + 1];

        Runnable update = new Runnable() {
            public void run() {}
        };
        class BITHelper {
            void updateBIT(int idx, int val) {
                while (idx < BIT.length) {
                    BIT[idx] += val;
                    idx += idx & -idx;
                }
            }

            int queryBIT(int idx) {
                int sum = 0;
                while (idx > 0) {
                    sum += BIT[idx];
                    idx -= idx & -idx;
                }
                return sum;
            }
        }
        
        BITHelper helper = new BITHelper();
        for (int i = n - 1; i >= 0; i--) {
            int idx = rankMap.get(nums[i]);
            int smallerCount = helper.queryBIT(idx - 1);
            result.add(smallerCount);
            helper.updateBIT(idx, 1); 
        }
        Collections.reverse(result);
        return result;
    }
}