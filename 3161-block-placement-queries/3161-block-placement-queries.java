class Solution {
    public List<Boolean> getResults(int[][] queries) {
        SegmentTree st = new SegmentTree();
        List<Boolean> results = new ArrayList<>();

        // place boundary obstacle at 0 always!
        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        st.update(0);

        for (int[] query : queries) {
            if (query[0] == 1) {
                st.update(query[1]);
                obstacles.add(query[1]);
            } else {
                int x  = query[1];
                int sz = query[2];

                int gap = st.query(0, x);

                // check trailing gap between last obstacle before x and x itself
                int lastObstacle = obstacles.floor(x);
                int trailingGap  = x - lastObstacle;

                results.add(Math.max(gap, trailingGap) >= sz);
            }
        }

        return results;
    }
}

class SegmentTree {

    private static class Node {
        int maxGap;
        int leftmost;
        int rightmost;
        int low;
        int high;
        Node left;
        Node right;

        public Node(int l, int r) {
            this.low = l;
            this.high = r;
        }
    }

    private Node root;

    public SegmentTree(){
        this.root = construct(0,50001);
    }


    private Node construct(int s, int e) {
        Node node = new Node(s, e);

        if (s == e) {
            node.leftmost  = Integer.MAX_VALUE;
            node.rightmost = Integer.MIN_VALUE;
            node.maxGap    = 0;
            return node;
        }

        int mid = s + (e - s) / 2;
        node.left  = construct(s, mid);
        node.right = construct(mid + 1, e);


        merge(node);
        return node;
    }

    private void merge(Node node) {
    node.leftmost  = Math.min(node.left.leftmost,  node.right.leftmost);
    node.rightmost = Math.max(node.left.rightmost, node.right.rightmost);

    // only compute crossGap if BOTH sides actually have obstacles!
    if (node.left.rightmost != Integer.MIN_VALUE && 
        node.right.leftmost != Integer.MAX_VALUE) {
        int crossGap = node.right.leftmost - node.left.rightmost;
        node.maxGap = Math.max(Math.max(node.left.maxGap, node.right.maxGap), crossGap);
    } else {
        node.maxGap = Math.max(node.left.maxGap, node.right.maxGap);
    }
}

    public void update(int i) {
        update(root, i);
    }

    private void update(Node node, int i) {
        if (node.low == i && node.high == i) {
            node.leftmost  = i;
            node.rightmost = i;
            node.maxGap    = 0;
            return;
        }

        int mid = node.low + (node.high - node.low) / 2;
        if (i <= mid) {
            update(node.left, i);
        } else {
            update(node.right, i);
        }

        merge(node);  // ← recompute on the way back up!
    }

    public int query(int l, int r) {
        return query(root, l, r).maxGap;
    }

    private Node query(Node node, int l, int r) {
        if (node.low >= l && node.high <= r) {
            return node;  // fully inside, return as is
        }

        int mid = node.low + (node.high - node.low) / 2;

        if (r <= mid) return query(node.left, l, r);
        if (l > mid)  return query(node.right, l, r);

        // spans both children → need to merge results!
        Node leftResult  = query(node.left, l, r);
        Node rightResult = query(node.right, l, r);

        // merge leftResult and rightResult into a temp node
        Node temp = new Node(l, r);
        temp.left  = leftResult;
        temp.right = rightResult;
        merge(temp);
        return temp;
    }
}