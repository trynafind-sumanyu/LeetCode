class Solution {
    public int[] scoreValidator(String[] events) {
        int[] ans = new int[2];

        int score = 0;
        int counter = 0;

        for(String s : events){
            if(counter == 10){
                return new int[]{score,counter};
            }

            if(s.charAt(0) == 'W' || s.charAt(0) == 'N'){
                if(s.length() == 2){
                    score++;
                }
                else{
                    counter++;
                }
            }
            else{
                score += Integer.parseInt(s);
            }
        }
        ans[0] = score;
        ans[1] = counter;
        return ans;
    }
}