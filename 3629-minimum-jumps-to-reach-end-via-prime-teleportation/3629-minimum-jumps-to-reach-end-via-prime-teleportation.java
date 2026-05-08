class Solution {
    static final int n = 1000005;
    static boolean[] prime = new boolean[n];
    static {
        Arrays.fill(prime,true);
        prime[0] = prime[1] = false; //if prime it is true
                                     // if not it is -> false

        for (int i = 2; i <= 1000; i++){
            if (prime[i]){
                for (int j = i * i; j < n; j += i){
                    prime[j] = false;
                }
            }
        }
    }

    public int minJumps(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        Map<Integer, List<Integer>> map = new HashMap<>(); // for each index -> Can go indexes

        for(int i = 0;i<n;i++){
            max = Math.max(max,nums[i]);
            map.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }

        boolean[] visited = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        Arrays.fill(visited,false);
        q.add(0);

        Set<Integer> seen = new HashSet<>();

        int steps = 0;

        while(!q.isEmpty()){

            int size = q.size();

            while(size -- > 0){
                int i = q.pop();
                

                if(i == n-1){
                    return steps;
                }

                if(i-1 >= 0 && !visited[i-1]){
                    q.add(i-1);
                    visited[i-1] = true;
                }
                if(i+1 <n  && !visited[i+1]){
                    q.add(i+1);
                    visited[i+1] = true;
                }

                if(!prime[nums[i]] || seen.contains(nums[i])){
                    continue;
                }

                for(int mult = nums[i];mult <= max;mult += nums[i]){
                    if(!map.containsKey(mult)){
                        continue;
                    }
                    for(int val : map.get(mult)){
                        if(!visited[val]){
                            q.add(val);
                            visited[val] = true;
                        }
                    }
                }

                seen.add(nums[i]);

            }
            steps++;
        }
        return steps;
    }
}