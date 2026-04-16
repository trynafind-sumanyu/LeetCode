class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int maxIndex = max(nums);
        int[] arr = new int[2 * n];

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i + n] = nums[i];
        }

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        int idx = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (arr[stack.peek()] < arr[i]) {
                    while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                        ans[stack.peek() % n] = arr[i];
                        stack.pop();
                    }
                    stack.push(i);
                } else {
                    stack.push(i);
                }
            }
        }

        ans[maxIndex] = -1;
        return ans;
    }

    private int max(int[] arr) {
        int max = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }

        }
        return index;
    }
}