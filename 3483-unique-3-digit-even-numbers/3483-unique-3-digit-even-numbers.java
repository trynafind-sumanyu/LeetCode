class Solution {
    public int totalNumbers(int[] digits) {
        int[] flag = new int[10];
        int res = 0;

        for (int d : digits) {
            flag[d]++;
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 9; k += 2) {
                    flag[i]--; 
                    flag[j]--; 
                    flag[k]--;

                    if (flag[i] >= 0 && flag[j] >= 0 && flag[k] >= 0) {
                        res++;
                    }

                    flag[i]++; 
                    flag[j]++; 
                    flag[k]++;
                } 
            }          
        }

        return res;
    }
}