class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFeed u = new UnionFeed(n);

        for(int[] arr : allowedSwaps){
            u.union(arr[0],arr[1]);
        }

        Map<Integer, Map<Integer,Integer>> grp = new HashMap<>();

        for(int i = 0;i<n;i++){
            int root = u.find(i);
            grp.computeIfAbsent(root, k -> new HashMap<>()).merge(source[i],1,Integer::sum);
        }

        int ans = 0;

        for(int i = 0;i<n;i++){
            int root = u.find(i);
            Map<Integer,Integer> freq = grp.get(root);
            if(freq.getOrDefault(target[i],0)>0){
                freq.merge(target[i],-1,Integer::sum);
            }
            else {
                ans++;
            }
        }
        return ans;
    }
}

class UnionFeed{
    int[] parent;
    UnionFeed(int n){
        parent = new int[n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
        }
        
    }

    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public void union(int a, int b){
        parent[find(a)] = find(b);
    }

}