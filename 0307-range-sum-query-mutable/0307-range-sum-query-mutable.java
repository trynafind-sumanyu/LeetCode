class NumArray {
    private SegmentTree tree;
    public NumArray(int[] nums) {
        tree = new SegmentTree(nums);
    }
    
    public void update(int index, int val) {
        tree.update(index,val);
    }
    
    public int sumRange(int left, int right) {
        return tree.query(left,right);
    }
}

class SegmentTree {
    private static class Node {
        int val;
        int rangeLow;
        int rangeHigh;
        Node left;
        Node right;

        public Node(int rangeLow, int rangeHigh){
            this.rangeLow = rangeLow;
            this.rangeHigh = rangeHigh;
        }
    }

    private Node root;

    public SegmentTree(int[] arr) {
        //create a tree using this array;
        this.root = constructTree(arr,0,arr.length-1);
    }

    private Node constructTree(int[] arr,int s, int e){
        Node node = new Node(s,e);
        if(s == e){
            node.val = arr[s];
            return node;
        }
        int mid = s +(e-s)/2;
        node.left = constructTree(arr,s,mid);
        node.right = constructTree(arr,mid+1,e);

        node.val = node.left.val + node.right.val;
        return node;
    }

    public void update(int index, int val){
        if(index < 0 || index > root.rangeHigh){
            throw new IllegalArgumentException("Invalid update index");
        }
        root.val = update(root,index,val);
    }

    private int update(Node node,int index,int val){
        if(node.rangeLow == index && node.rangeHigh == index){
            node.val = val;
            return node.val;
        }

        if(node.rangeHigh < index){
            return node.val;
        }

        if(node.rangeLow > index){
            return node.val;
        }

        node.val = update(node.left,index,val) + update(node.right,index,val);
        return node.val;
    }

    public int query(int start,int end){
        return query(start,end,root);
    }

    private int query(int start,int end,Node node){
        if(node.rangeLow >  end ||   node.rangeHigh < start){
            //range is out of query length --> return 0.
            return 0;
        }

        if(node.rangeLow == start && node.rangeHigh == end){
            // exact range of query found return ans
            return node.val;
        }

        if(node.rangeLow >= start && node.rangeHigh <= end){
            // full range of the node is inside the query --> return its val
            // also returning the leaf node val

            /*
                for example - query[3,4]
                we enter the leaf node 3 (rL = rH = 3)

                here 3 >= start and 3 <= end hence return the val

                also if we land on leaf node 4

                here 4 >= start and 4 <= end hence return the val
             */
            return node.val;
        }

        return query(start,end,node.left)+query(start,end,node.right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */