class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int ans = 0;
        Tree t = new Tree(baskets);
        for(int f : fruits){
            if(!t.query(f)){
                ans++;
            }
        }
        return ans;
    }
}

class Tree{

    private class Node {
        int val;
        int low;
        int high;
        Node left;
        Node right;

        public Node(int low, int high){
            this.low = low;
            this.high = high;
        }
    }

    private Node root;

    public Tree(int[] nums){
        root = build(nums,0,nums.length-1);
    }

    private Node build(int[] arr,int s, int e){
        Node node = new Node(s,e);
        if(s == e){
            node.val = arr[s];
            return node;
        }

        int m = s + (e-s)/2;

        node.left = build(arr,s,m);
        node.right = build(arr,m+1,e);

        node.val = Math.max(node.left.val,node.right.val);
        return node;
    }

    public void update(int idx){
       root.val = update(idx,root);
    }

    private int update(int i,Node node){
        if(node.low == i && node.high == i){
            node.val = -1;
            return -1;
        }

        if(node.low > i || node.high < i){
            return node.val;
        }

        node.val = Math.max(update(i,node.left),update(i,node.right));
        return node.val;
    }

    public boolean query(int fruit){
        return query(fruit,root);
    }

    private boolean query(int f,Node node){
        if(node.left == null && node.right == null){
            if(node.val >= f){
                update(node.low);
                return true;
            }
            else return false;
        }

        if(node.left.val < f){
            return query(f,node.right);
        }
        else{
            return query(f,node.left);
        }
    }
}