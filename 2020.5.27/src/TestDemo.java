/**
 * @program: 2020.5.27
 * @description:
 * @author: spdz
 * @create: 2020-05-26 20:08
 **/

public class TestDemo {

    public static void main(String[] args) {
        Tree t = new Tree();
        Node root = t.buildTree();
        t.pre(root);
        System.out.println();
        t.display(t.Convert(root));
    }
}

