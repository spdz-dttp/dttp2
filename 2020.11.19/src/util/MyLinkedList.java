package util;

/**
 * @program: 2020.11.19
 * @description: 双向链表
 * @author: spdz
 * @create: 2020-11-19 15:08
 **/
public class MyLinkedList {
    private Node head;
    private Node last;
    private int size;

    //尾插法
    public boolean add(String e) {
        Node node = new Node(e);
        if (head == null) {
            head = last = node;
        }else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
        return true;
    }

    //再 index 添加一个 值为e 的结点
    public void add (String e,int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("下标越界：" + index);
        }
        Node node = new Node(e);
        if (head == null) {
            head = last = node;
        }else if (index == 0) {
            node.next = head;
            head.prev = node;
            head = node;
        }else if (index == size()) {
            last.next = node;
            node.prev = last;
            last = node;
        }else {
            Node prev = getPrevByIndex(index);
            node.next = prev.next;
            node.next.prev = node;
            prev.next = node;
            node.prev = prev;
        }
        size++;
    }

    //删除 index 的结点
    public String remove(int index) {
        checkIndex(index);
        String val;
        if (size() == 1) {
            val = head.val;
            head = last = null;
        }else if (index == 0) {
            val = head.val;
            head = head.next;
            head.prev = null;
        }else if (index == size() - 1) {
            val = last.val;
            last = last.prev;
            last.next = null;
        }else {
            Node prev = getPrevByIndex(index);
            val = prev.next.val;
            prev.next.next.prev = prev;
            prev.next = prev.next.next;
        }
        size--;
        return val;
    }

    //删除第一个值为 e 的结点
    public boolean remove(String e) {
        Node cur = head;
        while (cur != null) {
            if (cur.val.equals(e)) {
                Node prev = cur.prev;
                Node next = cur.next;
                if (prev != null) {
                    prev.next = next;
                }else {
                    head = head.next;
                }
                if (next != null) {
                    next.prev = prev;
                }else {
                    last = last.prev;
                }
                size--;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //获得 index 前一个结点的 引用
    private Node getPrevByIndex(int index) {
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        return prev;
    }

    //链表长度
    public int size() {
        return size;
    }

    //获得 index 的值
    public String get(int index) {
        checkIndex(index);
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.val;
    }

    //替换 index 的值，返回原值
    public String set(int index, String e) {
        checkIndex(index);
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        String oldval = node.val;
        node.val = e;
        return oldval;
    }

    //判断 index是否越界
    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("下标越界" + index);
        }
    }

    //获得第一个 e 的index
    public int indexOf(String e) {
        Node node = head;
        for (int i = 0; i < size(); i++) {
            if (node.val.equals(e)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    //获得最后一个 e 的index
    public int lastIndexOf(String e) {
        Node node = last;
        for (int i = size()-1; i >= 0; i--) {
            if (node.val.equals(e)) {
                return i;
            }
            node = node.prev;
        }
        return -1;
    }

    //判断链表是否包含 e
    public boolean contains(String e) {
        return indexOf(e) != -1;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return size() == 0;
    }

}
