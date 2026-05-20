class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] C = new int[n];

        int[] freq = new int[n+1];
       

        int count = 0;
        // for(int i = 0;i<n; i++){
        //     isPresA[A[i]] = true;
        //     int count = 0;
        //     for(int j = 0;j<=i;j++){
        //         if(isPresA[B[j]]){
        //             count++;
        //         }
        //     }
        //     C[i] = count;
        // }

        for(int i = 0;i<n;i++){
            freq[A[i]]++;
            freq[B[i]]++;

            if(freq[A[i]] == 2){
                count++;
            }
            if(freq[B[i]] == 2){
                count++;
            }
            if(A[i] == B[i]){
                count--;
            }
            C[i] = count;
        }

        return C;
    }   
}