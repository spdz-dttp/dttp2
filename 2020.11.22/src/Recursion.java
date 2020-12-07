import java.util.ArrayList;
import java.util.List;

/**
 * @program: 2020.11.22
 * @description:递归练习
 * @author: spdz
 * @create: 2020-11-22 16:08
 **/
public class Recursion {

    //斐波那契数
    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n不能小于0");
        }
        if (n == 0) {
            return 0;
        }else if (n == 1) {
            return 1;
        }else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    //汉诺塔(n 个盘子)
    //从from 移到 to
    //柱子编号 0  1  2
    public static void hanoi(int n,int from, int to) {
        if (n < 1) {
            throw new IllegalArgumentException("n必须大于等于1");
        }
        if (n == 1) {
            System.out.printf("将一个盘子从 %d 移到 %d%n", from, to);
            return;
        }
        int other = (0+1+2)-from-to;
        hanoi(n-1,from,other);
        System.out.printf("将一个盘子从 %d 移到 %d%n", from, to);
        hanoi(n-1,other,to);
    }

    public static void main(String[] args) {
        hanoi(3,0,2);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //前序遍历二叉树
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }



    //根据一棵树的前序遍历与中序遍历构造二叉树(1)。
    private static TreeNode buildTreeByList(List<Integer> preorderList, List<Integer> inorderList) {
        if (preorderList.isEmpty()) {
            return null;
        }

        int rootVal = preorderList.get(0);
        int rootIndex = inorderList.indexOf(rootVal);
        int leftTreeSize = rootIndex;

        List<Integer> leftSubTreePreorderList = preorderList.subList(1, 1 + leftTreeSize);
        List<Integer> leftSubTreeInorderList = inorderList.subList(0, 0 + leftTreeSize);
        TreeNode leftSubTreeRoot = buildTreeByList(leftSubTreePreorderList, leftSubTreeInorderList);

        List<Integer> rightSubTreePreorderList = preorderList.subList(1 + leftTreeSize, preorderList.size());
        List<Integer> rightSubTreeInorderList = inorderList.subList(leftTreeSize + 1, inorderList.size());
        TreeNode rightSubTreeRoot = buildTreeByList(rightSubTreePreorderList, rightSubTreeInorderList);

        TreeNode root = new TreeNode(rootVal);
        root.left = leftSubTreeRoot;
        root.right = rightSubTreeRoot;

        return root;
    }

    public static TreeNode buildTree1(int[] preorder, int[] inorder) {
        List<Integer> preorderList = arrayToList(preorder);
        List<Integer> inorderList = arrayToList(inorder);

        return buildTreeByList(preorderList, inorderList);
    }

    private static List<Integer> arrayToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        return list;
    }

    //根据一棵树的前序遍历与中序遍历构造二叉树(2)。
    private static int index = 0;
    private static TreeNode buildTreeChild(int[] preorder,int[] inorder,int begin,int end) {
        if(begin > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int rootIndex = findIndexOfInder(preorder[index],inorder,begin,end);
        index++;
        if (rootIndex == -1) {
            return null;
        }
        root.left = buildTreeChild(preorder, inorder, begin, rootIndex-1);
        root.right = buildTreeChild(preorder, inorder, rootIndex+1, end);
        return root;
    }

    private static int findIndexOfInder(int val,int[] inorder,int begin,int end) {
        for (int i = begin; i <= end; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static TreeNode buildTree2(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length <= 0 || inorder.length <= 0) {
            return null;
        }

        return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }

}
