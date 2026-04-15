class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) {
                return "";
            }
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] != lcp[j][i]) {
                    return "";
                }
            }
        }

        DSU d = new DSU(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] > 0) {
                    d.union(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] == 0) {
                    if (d.find(i) == d.find(j)) {
                        return "";
                    }
                }
            }
        }

        Map<Integer, Character> map = new HashMap<>();
        char ch = 'a';

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int root = d.find(i);
            if (!map.containsKey(root)) {
                if (ch > 'z')
                    return "";
                map.put(root, ch++);
            }
            sb.append(map.get(root));
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int val = 0;
                if (sb.charAt(i) == sb.charAt(j)) {
                    if (i + 1 < n && j + 1 < n) {
                        val = 1 + lcp[i + 1][j + 1];
                    } else {
                        val = 1;
                    }
                }
                if (val != lcp[i][j]) {
                    return "";
                }
            }
        }
        return sb.toString();
    }

    private int[][] transpose(int[][] mat) {
        int n = mat.length;
        int[][] t = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t[j][i] = mat[i][j];
            }
        }
        return t;
    }
}

class DSU {
    int[] p;

    public DSU(int n) {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
    }

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            p[pb] = pa;
        }
    }
}