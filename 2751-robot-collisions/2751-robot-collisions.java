class Solution {
    public List<Integer> survivedRobotsHealths(int[] pos, int[] h, String dir) {
        int n = pos.length;
        Integer[] order = new Integer[n];
        for(int i=0;i<n;i++){
            order[i]=i;
        }

        Arrays.sort(order,(a,b)->pos[a]-pos[b]);

        boolean[] alive = new boolean[n];
        Arrays.fill(alive,true);

        Stack<Integer> s = new Stack<>();

        for(int i : order){
            if(dir.charAt(i)=='R'){
                s.push(i);
            }
            else{
                while (!s.isEmpty()){
                    int top = s.peek();

                    if(h[top] < h[i]){
                        alive[top] = false;
                        h[i]--;
                        s.pop();
                    }
                    else if(h[top]>h[i]){
                        alive[i] = false;
                        h[top]--;
                        break;
                    }
                    else{
                        alive[i] = false;
                        alive[top] = false;
                        s.pop();
                        break;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(alive[i]){
                ans.add(h[i]);
            }
        }
        return ans;
    }
}