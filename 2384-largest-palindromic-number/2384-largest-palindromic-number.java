class Solution {
    public String largestPalindromic(String num) {
        int[] freq = new int[10];

        for(char c : num.toCharArray()){
            freq[c-'0']++;
        }

        int mid = -1;
        boolean odd = false;
        StringBuilder sb = new StringBuilder();

        for(int i = 9;i>=0;i--){
            if(freq[i] == 0){
                continue;
            }
            if(freq[i] % 2 == 1 && !odd){
                mid = i;
                odd = true;
            }

            if(i == 0 && sb.length() == 0){
                break;
            }

            int t = freq[i]/2;
            while(t-- > 0){
                sb.append(i);
            }
        }

        StringBuilder rev = new StringBuilder(sb).reverse();

        sb.append(rev);
        if(mid != -1){
            sb.insert(sb.length()/2,mid);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}