class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        boolean aPos = false;
        boolean ePos = false;
        boolean iPos = false;
        boolean oPos = false;
        boolean uPos = false;

        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;
        List<Character> order = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                a++;
            }
            if (c == 'e') {
                e++;
            }
            if (c == 'i') {
                i++;
            }
            if (c == 'o') {
                o++;
            }
            if (c == 'u') {
                u++;
            }
        }
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                if (order.contains(c)) {
                    continue;
                } else {
                    order.add(c);
                }
            }
        }

        final int fa = a, fe = e, fi = i, fo = o, fu = u;
        order.sort((x, y) -> {
            int fx = x == 'a' ? fa : x == 'e' ? fe : x == 'i' ? fi : x == 'o' ? fo : fu;
            int fy = y == 'a' ? fa : y == 'e' ? fe : y == 'i' ? fi : y == 'o' ? fo : fu;
            return fy - fx;
        });

        Stack<Character> stack = new Stack<>();

        for (int j = order.size() - 1; j >= 0; j--) {
            char c = order.get(j);
            int freq = c == 'a' ? a : c == 'e' ? e : c == 'i' ? i : c == 'o' ? o : u;
            for (int k = 0; k < freq; k++) {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                sb.append(stack.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}