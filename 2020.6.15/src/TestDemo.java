/**
 * @program: 2020.6.15
 * @description:
 * @author: spdz
 * @create: 2020-07-08 22:35
 **/
public class TestDemo {

    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        int[] arr = {7,2,9,18,56,15,3};
        for (int i : arr) {
            bsTree.insert(i);
        }
        bsTree.preOrder(bsTree.root);
        System.out.println();
        bsTree.inOrder(bsTree.root);
        System.out.println();
        System.out.println(bsTree.search(18).val);//18
        System.out.println(bsTree.search(180));//null
        System.out.println();
        System.out.println(bsTree.remove(18));
        bsTree.preOrder(bsTree.root);
        System.out.println();
        bsTree.inOrder(bsTree.root);
    }
}
