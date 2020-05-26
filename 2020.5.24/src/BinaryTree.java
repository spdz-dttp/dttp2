import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: 2020.5.24
 * @description:
 * @author: spdz
 * @create: 2020-05-21 22:38
 **/

class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}

public class BinaryTree {

    public Node buildTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }

    // 前序遍历
    public void preOrderTraversal(Node root){
        if (root == null) {
            return;
        }
        System.out.print(root.val + "");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    // 中序遍历
    public void inOrderTraversal(Node root){
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + "");
        inOrderTraversal(root.right);
    }
    // 后序遍历
    public void postOrderTraversal(Node root){
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + "");
    }

    // 遍历思路-求结点个数
    static int size = 0;
    public void getSize1(Node root){
        if (root == null) {
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }

    // 子问题思路-求结点个数
    public int getSize2(Node root){
        if (root == null) {
            return 0;
        }
        return  getSize2(root.left) + getSize2(root.right) + 1;
    }

    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    public void getLeafSize1(Node root){
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafSize++;
        }else {
            getLeafSize1(root.left);
            getLeafSize1(root.right);
        }
    }

    // 子问题思路-求叶子结点个数
    public int getLeafSize2(Node root){
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    // 子问题思路-求第 k 层结点个数
    public int getKLevelSize(Node root,int k){
        if (root == null) {
            return 0;
        }
        if (k == 1) {
             return 1;
        }
        return getKLevelSize(root.left,k-1)
                + getKLevelSize(root.right, k-1);
    }

    // 获取二叉树的高度
    public int getHeight(Node root){
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return left > right ? left+1 : right+1;
    }

    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    public Node find(Node root, char val){
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        Node left = find(root.left,val);
        if (left != null) {
            return left;
        }
        Node right = find(root.right,val);
        if (right != null) {
            return right;
        }
        return null;
    }

    //两棵二叉树是否相同
    public boolean isSameTree(Node p, Node q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    //一颗二叉树是否包含另一颗二叉数的所有
    public boolean isSubtree(Node s, Node t) {
        if (s == null || t == null) {
            return false;
        }
        if (isSameTree(s,t)) {
            return true;
        }
        if (isSubtree(s.left,t)) {
            return true;
        }
        if (isSubtree(s.right,t)) {
            return true;
        }
        return false;
    }

    // 层序遍历
    public void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }

}
