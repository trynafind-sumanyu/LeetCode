class Solution {
    public int totalFruit(int[] fruits) {
        int secondlast = -1;
        int last = -1;
        int lastCount = 0;
        int total = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < fruits.length; i++){
            if(secondlast == fruits[i] || last == fruits[i]){
                 total++;
            }
            else {
                total = lastCount + 1;
            }

            if(fruits[i] == last) {
                lastCount++;
            }
            else {
                lastCount = 1;
                secondlast = last;
                last = fruits[i];
            }

            max = Math.max(max, total);
        }

        return max;
    }
}