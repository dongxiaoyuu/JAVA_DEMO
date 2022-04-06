package tree;

/**
 * Created with IntelliJ IDEA
 * Description:二叉搜索树
 * User:dxy
 * Date:2022-04-03
 * Time:20:37
 */
public class SearchTree {
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public  TreeNode root;

    public boolean search(int val) {
        if (root == null) return false;
        TreeNode cur = root;
        while (cur!=null) {
            if (cur.val == val) {
                return true;
            } else if (cur.val > val) {
                cur = cur.left;
            }else cur=cur.right;
        }
        return false;
    }

    public  boolean insert(int val){
        if(root==null){
            root=new TreeNode(val);
            return true;
        }
        TreeNode cur=root;
        TreeNode parent=null;
        while (cur!=null){
            if(cur.val<val){
                parent=cur;
                cur=cur.right;
            }else if(cur.val>val){
                parent=cur;
                cur=cur.left;
            }else
                return false;
        }
        if(parent.val<val){
            parent.right=new TreeNode(val);
        }else{
            parent.left=new TreeNode(val);
        }
        return true;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }


    public void removeNode(TreeNode parent ,TreeNode cur) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (parent.right == cur) {
                parent.right = cur.right;
            } else {
                parent.left = cur.left;
            }
        }else if(cur.right==null){
            if(cur==root){
                root=cur.left;
            }else if(parent.left==cur){
                parent.left=cur.left;
            }else {
                parent.right=cur.left;
            }
        }else {
            TreeNode target =cur.right;
            TreeNode targetParent=cur;
            while (target!=null){
                targetParent =target;
                target=target.left;
            }
            cur.val=target.val;
            if(target==targetParent.left){
                targetParent.left=target.left;
            }else {
                targetParent.right=target.left;
            }

        }
    }


    public boolean remove(int k){
        if(root==null){
            return false;
        }
        TreeNode cur=root;
        TreeNode parent=null;
        while (cur!=null){
            if(cur.val<k){
                parent=cur;
                cur=cur.right;
            }else if(cur.val>k){
                parent=cur;
                cur=cur.left;
            }else{
                removeNode(parent,cur);
                return true;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        SearchTree searchTree=new SearchTree();

        searchTree.insert(11);
        searchTree.insert(29);
        searchTree.insert(90);
        searchTree.insert(67);
        searchTree.insert(4);
        searchTree.inorder(searchTree.root);
        System.out.println("删除节点90后=========");
        searchTree.remove(90);
        searchTree.inorder(searchTree.root);
    }
}
