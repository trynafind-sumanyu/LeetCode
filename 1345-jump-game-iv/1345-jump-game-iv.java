class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> index = new HashMap<>();

        for(int i = 0;i< n; i++){
            index.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        boolean[] visited = new boolean[n];

        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i < size;i++){
                int cur = q.pop();
                visited[cur] = true;
                if(cur == n-1){
                    return level;
                }

                if(!visited[cur+1]){
                    q.add(cur+1);
                    visited[cur+1] = true;
                }
                if(index.containsKey(arr[cur])) {
                    for (int j : index.get(arr[cur])) {
                        if (!visited[j]) {
                            visited[j] = true;
                            q.add(j);
                        }
                    }
                    index.remove(arr[cur]);
                }
                if(cur != 0) {
                    if (!visited[cur - 1]) {
                        q.add(cur - 1);
                        visited[cur - 1] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}