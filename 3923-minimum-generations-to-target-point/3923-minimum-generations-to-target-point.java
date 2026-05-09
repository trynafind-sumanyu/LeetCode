class Solution {
    public int minGenerations(int[][] points, int[] target) {
        List<List<Integer>> p = new ArrayList<>();
        List<Integer> t = new ArrayList<>(Arrays.asList(target[0],target[1],target[2]));
        Set<List<Integer>> seen = new HashSet<>();
        int index = 0;
        for(int[] r : points){
            p.add(new ArrayList<>(Arrays.asList(r[0],r[1],r[2])));
            seen.add(p.get(index++));
        }
        if(seen.contains(t)){
            return 0;
        }
        int level = 0;
        int k = 20;
        while(k-- > 0){
            int size =  p.size();
            if(seen.contains(t)){
                return level;
            }
            for(int i = 0;i<size;i++){
                for(int j = i+1;j<size;j++){
                    int x = (p.get(i).get(0) + p.get(j).get(0))/2;
                    int y = (p.get(i).get(1) + p.get(j).get(1))/2;
                    int z = (p.get(i).get(2) + p.get(j).get(2))/2;
                    List<Integer> n = new ArrayList<>(Arrays.asList(x,y,z));
                    if(!seen.contains(n)){
                        p.add(n);
                        seen.add(n);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}