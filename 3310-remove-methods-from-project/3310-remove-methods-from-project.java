class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<Integer>[] adj = new ArrayList[n]; //Adjaceny graph

        boolean[] sus = new boolean[n];

        for(int i = 0;i<n;i++){
            adj[i] = new ArrayList<>();
            sus[i] = false;
        }



        int[] inDeg = new int[n]; //Indegree count krenge

        for(int[] inv : invocations){
            int a = inv[0];
            int b = inv[1];

            adj[a].add(b);
            inDeg[b]++;
        }


        //BFS
        Deque<Integer> q = new ArrayDeque<>();
        q.push(k);
        sus[k] = true;

        while(!q.isEmpty()){
            int curr = q.pop();

            for(int nbr : adj[curr]){
                inDeg[nbr]--;

                if(!sus[nbr]){
                    q.push(nbr);

                    sus[nbr] = true;
                }
            }
        }

        List<Integer> ans  = new ArrayList<>();

        for(int i = 0;i<n;i++){
            if(sus[i] && inDeg[i] > 0){
                // Means non sus is connected to sus and can not remove anything return all nodes
                List<Integer> res = new ArrayList<>();
                for(int j = 0; j < n;j++){
                    res.add(j);
                }
                return res;
            }

            if(!sus[i]){
                ans.add(i);
            }

        }

        return ans;
    }
}