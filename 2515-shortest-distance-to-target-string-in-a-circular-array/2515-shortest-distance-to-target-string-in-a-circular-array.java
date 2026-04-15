class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int left = 0;
        int right = 0;
        boolean found = false;
        int i = startIndex;
        do{
            if(words[i].equals(target)){
                found = true;
                break;
            }
            i = (i+1)%n;
            left++;
        }while(i != startIndex);
        if(!found){
            return -1;
        }
        i = startIndex;
        do{
            if(words[i].equals(target)){
                break;
            }
            if(i == 0){
                i = words.length-1;
            }
            else{
                i--;
            }
            right++;
        }while(i!=startIndex);

        return Math.min(right,left);
    }
}