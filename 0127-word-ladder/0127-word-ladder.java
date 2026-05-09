class Solution {
    public int ladderLength(String begin, String end, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Set<String> seen = new HashSet<>();

        if (!words.contains(end)) {
            return 0;
        }

        Deque<String> q = new ArrayDeque<>();
        int level = 1;
        q.add(begin);
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                String cur = q.pop();

                seen.add(cur);
                if (cur.equals(end)) {
                    return level;
                }


                fill(q, cur, seen, words);
            }
            level++;
        }

        return 0;
    }

    private void fill(Deque<String> q, String cur, Set<String> seen, Set<String> words) {

        char[] arr = cur.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            int index = c-'a';
            for(int j = 1;j<=index;j++){
                char dec = (char)(c-j);

                arr[i] = dec;
                String nD = String.valueOf(arr);
                if(words.contains(nD)){

                    if(!seen.contains(nD)){
                        seen.add(nD);
                        q.add(nD);
                    }
                }
            }

            for(int j = 1;j<=25-index;j++){
                char inc = (char)(j+c);
                arr[i]  =  inc;
                String nD = String.valueOf(arr);
                if(words.contains(nD)){
                    if(!seen.contains(nD)){
                        seen.add(nD);
                        q.add(nD);
                    }
                }
            }

            arr[i] = c;
        }
    }
}