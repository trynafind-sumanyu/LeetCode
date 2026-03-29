class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        if(Arrays.equals(c1,c2)){
            return true;
        }
        swap(c1,0,2);
        if(Arrays.equals(c1,c2)){
            return true;
        }
        swap(c1,1,3);
        if(Arrays.equals(c1,c2)){
            return true;
        }
        swap(c1,0,2);
        if(Arrays.equals(c1,c2)){
            return true;
        }
        return false;
        
    }

    private void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}