class Solution {
    public List<String> subdomainVisits(String[] domains) {
        Map<String, Long> map = new HashMap<>();

        for (String s : domains) {
            String[] split = s.split(" ");
            map.put(split[1], map.getOrDefault(split[1],0L)+Long.parseLong(split[0]));

            String[] split2 = split[1].split("\\.");
            if (split2.length == 2) {
                map.put(split2[1], map.getOrDefault(split2[1], 0L) + Long.parseLong(split[0]));
            }
            if (split2.length == 3) {
                map.put(split2[1] + "." + split2[2], map.getOrDefault(split2[1] + "." + split2[2], 0L) + Long.parseLong(split[0]));
                map.put(split2[2], map.getOrDefault(split2[2], 0L) + Long.parseLong(split[0]));
            }
        }

        List<String> ans = new ArrayList<>();

        for (Map.Entry<String, Long> entry : map.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            ans.add(value+" "+key);
        }
        return ans;
    }
}