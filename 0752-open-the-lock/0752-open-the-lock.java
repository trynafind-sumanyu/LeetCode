class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));


        String start = "0000";

        if(dead.contains(start)){
            return -1;
        }

        Deque<String> q = new ArrayDeque<>();
        q.add(start);

        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                String f = q.pop();
                dead.add(f);
                if(f.equals(target)){
                    return level;
                }

                fillNeighbours(q,f,dead);
            }
            level++;
        }
        return -1;
    }

    private void fillNeighbours(Deque<String> q, String curr, Set<String> dead){
        char[] arr = curr.toCharArray();
        for(int i = 0;i<4;i++){
            char c = arr[i];

            char inc = c == '9' ? '0' : (char)(c+1);
            char dec = c == '0' ? '9' : (char)(c-1);

            arr[i] = inc;
            if(!dead.contains(String.valueOf(arr))){
                q.add(String.valueOf(arr));
                dead.add(String.valueOf(arr));
            }

            arr[i] = dec;
            if(!dead.contains(String.valueOf(arr))){
                q.add(String.valueOf(arr));
                dead.add(String.valueOf(arr));
            }
            arr[i] = c;
        }
    }
}