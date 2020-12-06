package 面试题;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: 2020.11.20
 * @description: 链表题
 * @author: spdz
 * @create: 2020-11-22 09:32
 **/
public class Solution {

    //逆置
    public Node reverse(Node head) {
        Node prev = null;
        Node cur = head;

        while (cur != null) {
            cur.prev = cur.next;
            cur.next = prev;
            prev = cur;
            cur = cur.prev;
        }
        return prev;
    }

    private int size(Node head) {
        Node cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    //回文
    public boolean palindrome(Node head) {
        int half = size(head)/2;
        Node cur1 = head;
        Node node = head;
        for (int i = 0; i < half; i++) {
            node = node.next;
        }
        Node reverseHead = reverse(node);
        Node cur2 = reverseHead;
        while (cur2 != null) {
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;

    }

    //合并两个有序链表
    public Node mergoTwo(Node head1,Node head2) {
        Node cur1 = head1;
        Node cur2 = head2;

        //创建新的链表
        Node head = new Node(-1);
        Node last = head;
        while (cur1 != null && cur2 != null) {
            Node node;
            if (cur1.val <= cur2.val) {
                node = cur1;
                cur1 = cur1.next;
            }else {
                node = cur2;
                cur2 = cur2.next;
            }
            //将最小数放到新链表中
            last.next = node;
            node.prev = last;
            last = node;
        }
        if (cur1 == null){
            last.next = cur2;
            cur2.prev = last;
        }else {
            last.next = cur1;
            cur1.prev = last;
        }
        head = head.next;
        head.prev = null;
        return head;
    }

    //合并多个有序链表
    public Node mergeMultiple(Node[] heads) {
        List<Node> headList = arrayToList(heads);
        if (headList.isEmpty()) {
            return null;
        }

        //创建新的链表
        Node anshead = new Node(-1);
        Node last = anshead;

        //如果 headList 中一个元素变为null ，remove 这个元素
        while(headList.size() >= 2) {
            int index = 0;
            for (int i = 0; i < headList.size(); i++) {
                if (headList.get(i).val <= headList.get(index).val) {
                    index = i;
                }
            }
            //index 就是最小的数
            Node node = headList.remove(index);
            //判断这个元素是否为空
            if (node.next != null) {
                headList.add(node.next);
            }

            //将最小数放到新链表中
            last = node;
            node.prev = last;
            last = node;
        }
        last.next = headList.get(0);
        anshead = anshead.next;
        anshead.prev = null;
        return anshead;
    }

    private List<Node> arrayToList(Node[] heads) {
        List<Node> list = new ArrayList<>();

        for (Node head : heads) {
            if (head != null) {
                list.add(head);
            }
        }
        return list;
    }

}
