package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:dx
 * Date:2022-03-19
 * Time:15:33
 */
class TreeNode{
    public String val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(String val){
        this.val=val;
    }
}
public class TreeBin {
    public TreeNode creationTree() {
        TreeNode A = new TreeNode("1");
        TreeNode B = new TreeNode(null);
        TreeNode C = new TreeNode("1");
        TreeNode D = new TreeNode(null);
        TreeNode E = new TreeNode("1");
        TreeNode F = new TreeNode(null);
        TreeNode G = new TreeNode("1");
        TreeNode H = new TreeNode(null);
        TreeNode I = new TreeNode("1");
        //TreeNode G = new TreeNode(null);
        TreeNode K = new TreeNode("1");
        TreeNode L = new TreeNode(null);
        TreeNode M = new TreeNode("1");
        TreeNode N = new TreeNode(null);
        TreeNode O = new TreeNode("1");
        TreeNode P = new TreeNode(null);
        TreeNode Q = new TreeNode("1");
        TreeNode R = new TreeNode(null);
        TreeNode S = new TreeNode("1");
        TreeNode T = new TreeNode(null);
        TreeNode U = new TreeNode("1");
        TreeNode V = new TreeNode("2");
        A.left=B;
        A.right=C;
        B.left=D;
        B.right=E;
        return A;
    }


    //先序遍历
    void preOreder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preOreder(root.left);
        preOreder(root.right);
    }
    //中序遍历
    void midOreder(TreeNode root){
        if(root==null){
            return;
        }
        midOreder(root.left);
        System.out.print(root.val+" ");
        midOreder(root.right);
    }
    //后序遍历
    void postOreder(TreeNode root){
        if(root==null){
            return;
        }
        postOreder(root.left);
        postOreder(root.right);
        System.out.print(root.val+" ");
    }
    //统计节点个数
    public static int count=0;
    void size(TreeNode root){
        if(root==null){
            return;
        }
        count++;
        size(root.right);
        size(root.left);
    }
    //统计叶子节点的个数
    public static int total=0;
    void getLeaf(TreeNode root){
        if (root==null){

            return;
        }
        if(root.left==null&&root.right==null){
            total++;
        }

            getLeaf(root.right);
            getLeaf(root.left);


    }
    //获取第K层节点个数
    int getKLeaf(int k,TreeNode root){
        if(k==0)
            return 0;
        if(k==1)
            return 1;
        return getKLeaf(k-1,root.left)+getKLeaf(k-1,root.right);

    }

    //获取树高
    int getHeigh(TreeNode root){
        if(root==null)
            return 0;
        int leftH=getHeigh(root.left);
        int rightH=getHeigh(root.right);
        return leftH>rightH?leftH+1:rightH+1;
    }

    //检测元素值为value的是否存在
    TreeNode find(TreeNode root,char val){

        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }

        TreeNode ret=find(root.left,val);
        if(ret!=null) return ret;
        TreeNode ret2=find(root.right,val);
        if(ret2!=null) return ret2;
        return null;

    }

    //判断一个树是否是完全二叉树
    public boolean isComplete(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        if(root!=null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur!=null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }
        while (queue.isEmpty()){
            TreeNode cur=queue.peek();
            if(cur!=null){
                return false;
            }else {
                queue.poll();
            }

        }
        return true;
    }

    //层序遍历
    public void  leverOrder(TreeNode root){
        Queue<TreeNode>queue=new LinkedList<>();
        if(root!=null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            System.out.println(cur.val+" ");
            if(cur.left!=null){
               queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.left);
            }


        }
    }


    //判断一个树是否平衡

    public static void main(String[] args) {
        TreeBin BT =new TreeBin();
        TreeNode a=BT.creationTree();

        System.out.print("先序遍历");
        BT.preOreder(a);
        System.out.print("   中序遍历：");
        BT.midOreder(a);
        System.out.print("   后序遍历：");
        BT.postOreder(a);

        BT.size(a);
        int cot=TreeBin.count;
        System.out.print("   节点个数："+cot);

        BT.getLeaf(a);
        int tot=TreeBin.total;
        System.out.println("   叶子个数："+tot);

        int k=2;
        int K =BT.getKLeaf(k,a);
        System.out.println("第"+k+"层有"+K+"个节点");

        TreeNode node=BT.find(a,'C');
        System.out.println(node.val);


    }
}
