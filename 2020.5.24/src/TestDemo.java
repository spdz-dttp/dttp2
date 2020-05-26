/**
 * @program: 2020.5.24
 * @description:二叉树
 * @author: spdz
 * @create: 2020-05-21 19:13
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 树 ：
 *    子树是不想交的
 *    除根结点外，每个结点有且仅有一个父结点
 *    一棵 N 个结点的树有 N-1 条边
 * 二叉树：
 *    一棵二叉树是结点的一个有限集合，该集合或者为空，
 *    或者是由一个根节点加上两棵别称为左子树和右子树的二叉树组成。
 * 二叉树的特点：
 *    1. 每个结点最多有两棵子树，即二叉树不存在度大于 2 的结点。
 *    2. 二叉树的子树有左右之分，其子树的次序不能颠倒，因此二叉树是有序树
 * 两种特殊二叉树：
 *    1、满二叉树：每一个层的结点数都达到最大值
 *    2、完全二叉树：对于深度为K的，有n个结点的二叉树，每一个结点都与
 *    深度为K的满二叉树中编号从1至n的结点一一对
 *    （应先放每个结点的左子树，再放这个结点的右子树，依次放入）
 *    （满二叉树是一种特殊的完全二叉树）
 * 二叉树的性质：
 *       1. 二叉树的 第 i 层 上最多有 2^(i-1) 个结点  (i>0)
 *       2. 深度为 K 的二叉树的 最大结点数 是 2^k -1  其中(k>=0)
 *       3. 一棵二叉树, 叶结点个数为 n1, 度为2的非叶结点个数为 n2,则 n1＝n2＋1
 *       4. 具有 n个结点 的 完全二叉树 的 深度k 为 log2(n+1)向上取整
 *       5. 具有n个结点 的 完全二叉树，如果按照 从上至下 从左至右 的顺序 对所有节点
 *       从0开始编号，则对于序号为 i 的结点有：
 *              双亲序号：(i-1)/2；i=0，i为根节点编号，无双亲节点
 *                  （已知 子结点序号，求 父结点序号 ： (i-1)/2 ）
 *              若2i+1<n，左孩子序号：2i+1，否则无左孩子
 *                  （已知 父结点序号，求 左孩子结点序号 ：  2i+1 ）
 *              若2i+2<n，右孩子序号：2i+2，否则无右孩子
 *                  （已知 父结点序号，求 右孩子结点序号 ：  2i+2 ）
 * 二叉树的遍历方式：
 *      前序遍历 ： 根 -》 左 -》 右
 *      中序遍历 ： 左 -》 根 -》 右
 *      后序遍历 ： 左 -》 右 -》 根
 */
public class TestDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        binaryTree.levelOrderTraversal(root);

    }

    public static void main1(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree();
        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.inOrderTraversal(root);
        System.out.println();
        binaryTree.postOrderTraversal(root);
        System.out.println();
        binaryTree.getSize1(root);
        System.out.println("节点个数:" + binaryTree.size);
        System.out.println("节点个数:" + binaryTree.getSize2(root));
        binaryTree.getLeafSize1(root);
        System.out.println("叶子节点数:" + binaryTree.leafSize);
        System.out.println("叶子节点数:" + binaryTree.getLeafSize2(root));
        System.out.println("第k层结点个数:" + binaryTree.getKLevelSize(root, 3));
        System.out.println("二叉树的高度:"+binaryTree.getHeight(root));
        System.out.println("查找结点val:" + binaryTree.find(root, 'H').val);
        System.out.println("查找结点val:" + binaryTree.find(root, 'x'));
    }
}
