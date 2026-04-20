class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length <= 1){
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(changed);

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i : changed){
            if(i%2 == 1){
                map.put(i,map.getOrDefault(i,0)+1);
            }
            else if(map.getOrDefault(i/2,0) == 0){
                map.put(i,map.getOrDefault(i,0)+1);

            }
            else{
                if(map.get(i/2) > 1){
                    list.add(i/2);
                    map.put(i/2,map.get(i/2)-1);
                }
                else{
                    list.add(i/2);
                    map.remove(i/2);
                }
            }
        }

        int[] ans = new int[list.size()];
        int index = 0;
        for(int i : list){
            ans[index++] = i;
        }

        return map.isEmpty() ? ans : new int[]{};

    }
}